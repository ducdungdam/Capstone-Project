package com.ducdungdam.dartfriends.widget.CollapsingToolbarLayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.utilities.UnitConverterUtils;


/**
 * Created by ducdungdam on 13.07.18.
 *
 * Extended CollapsingToolbarLayout to handle Profile Image by implementing an additional
 * OnOffsetListener.
 */

public class CollapsingToolbarLayout extends android.support.design.widget.CollapsingToolbarLayout {

  private static final int IMAGE_BUTTON_TOOLBAR_GRAVITY_START = 0;
  private static final int IMAGE_BUTTON_TOOLBAR_GRAVITY_END = 1;

  private OnOffsetChangedListener onOffsetChangedListener;
  private ImageButton imageButton;
  private LinearLayout linearLayout;

  String collapsingToolbarDimensionRatio;
  String height;
  String width;
  int imageButtonToolbarGravity;
  float imageButtonMargin;
  PointF imageButtonStart;
  PointF imageButtonDistance;
  float imageButtonScaleDistance;

  public CollapsingToolbarLayout(Context context) {
    super(context);
  }

  public CollapsingToolbarLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public CollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    // Get Styleable Values to set Ratio
    final TypedArray typedArray = context
        .obtainStyledAttributes(attrs, R.styleable.CollapsingToolbarLayout, 0, 0);

    if (typedArray
        .hasValue(R.styleable.CollapsingToolbarLayout_layout_collapsingToolbarDimensionRatio)) {
      collapsingToolbarDimensionRatio = typedArray
          .getString(R.styleable.CollapsingToolbarLayout_layout_collapsingToolbarDimensionRatio);
    }

    if (typedArray
        .hasValue(R.styleable.CollapsingToolbarLayout_imageButtonToolbarMargin)) {
      String str = typedArray
          .getString(R.styleable.CollapsingToolbarLayout_imageButtonToolbarMargin);
      imageButtonMargin = UnitConverterUtils.StringToPx(getResources(), str);
    }

    if (typedArray.hasValue(R.styleable.CollapsingToolbarLayout_imageButtonToolbarGravity)) {
      imageButtonToolbarGravity = typedArray
          .getInt(R.styleable.CollapsingToolbarLayout_imageButtonToolbarGravity, -1);
    }

    height = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
    width = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_width");
    typedArray.recycle();
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

    final ViewParent parent = getParent();
    if (parent instanceof AppBarLayout) {
      // Register Listener
      if (onOffsetChangedListener == null) {
        onOffsetChangedListener = new OnOffsetChangedListener();
      }
      ((AppBarLayout) parent).addOnOffsetChangedListener(onOffsetChangedListener);
      getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }
    ViewCompat.requestApplyInsets(this);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    // Calculate ratio. If w or h is set to 0, it will calculate its size from the other value multiplied with aspect ratio to support different Screen sizes.
    if (width != null &&
        height != null &&
        collapsingToolbarDimensionRatio != null) {
      String[] dimensionRatio = collapsingToolbarDimensionRatio.split(":");

      float aspectRatio =
          Float.parseFloat(dimensionRatio[0]) / Float.parseFloat(dimensionRatio[1]);
      int w = Integer.parseInt(width.replaceAll("[^\\d-]", ""));
      int h = Integer.parseInt(height.replaceAll("[^\\d-]", ""));
      AppBarLayout.LayoutParams collapseParams = (AppBarLayout.LayoutParams) this.getLayoutParams();

      if (w == 0) {
        collapseParams.width = (int) (View.MeasureSpec.getSize(heightMeasureSpec) * aspectRatio);
      } else if (h == 0) {
        collapseParams.height = (int) (View.MeasureSpec.getSize(widthMeasureSpec) * aspectRatio);
      }
      setLayoutParams(collapseParams);
    }
  }

  @Override
  protected void onDetachedFromWindow() {

    final ViewParent parent = getParent();

    if (onOffsetChangedListener != null && parent instanceof AppBarLayout) {
      ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
    }

    super.onDetachedFromWindow();
  }

//  @BindingAdapter("app:title")
//  public static void setTitle(CollapsingToolbarLayout collapsingToolbarLayout, String title) {
//    collapsingToolbarLayout.setTitle(title);
//  }

  OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
      // Find all necessary Values from View after layout has been done but before display
      getViewTreeObserver().removeOnGlobalLayoutListener(this); // Only need to calculate once
      PointF imageButtonTargetSize = new PointF();
      PointF imageButtonPadding = new PointF(UnitConverterUtils.dpToPx(getResources(), 16),
          UnitConverterUtils.dpToPx(getResources(), 16));
      for (int i = 0; i < getChildCount(); i++) {
        View child = getChildAt(i);
        if (child instanceof Toolbar) {
          imageButtonTargetSize.x = child.getHeight() - imageButtonPadding.x;
          imageButtonTargetSize.y = child.getHeight() - imageButtonPadding.y;
          if (imageButtonToolbarGravity == IMAGE_BUTTON_TOOLBAR_GRAVITY_START) {
            // Placeholder to move title to the right, if Image will move to right
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) child.getLayoutParams();
            params.setMargins((int)(imageButtonTargetSize.x+imageButtonMargin), 0, 0, 0);
            child.setLayoutParams(params);
          }
        }
        if (child instanceof ImageButton) {
          imageButton = (ImageButton) child;
          imageButtonStart = new PointF(child.getX(), child.getY());
        }
        if (child instanceof LinearLayout) {
          linearLayout = (LinearLayout) child;
        }
      }

      //Calculate here, because we need all necessary values first.
      imageButtonDistance = new PointF();

      imageButtonScaleDistance = 0;
      if ((imageButton.getHeight() - imageButtonTargetSize.y)
          != 0) { // Avoids to divide with 0 by chance.
        imageButtonScaleDistance = 1 - (imageButtonTargetSize.y / imageButton
            .getHeight()); // Distance is Delta: e.g.: 100% - target = distance
      }

      // Need scaleOffset, because Android won't update View Size and Position in respect of Coordinate System after Scaling
      float scaleOffsetY =
          (imageButton.getWidth() - imageButtonTargetSize.x + imageButtonPadding.x) / 2;
      switch (imageButtonToolbarGravity) {
        case IMAGE_BUTTON_TOOLBAR_GRAVITY_START:
          float scaleOffsetStart =
              (imageButton.getWidth() - imageButtonTargetSize.x - imageButtonPadding.x) / 2;
          imageButtonDistance.x =
              0 - imageButtonStart.x - scaleOffsetStart + imageButtonMargin;
          imageButtonDistance.y =
              getHeight() - imageButtonStart.y - imageButtonTargetSize.y - scaleOffsetY;
          break;
        case IMAGE_BUTTON_TOOLBAR_GRAVITY_END:
          float scaleOffsetEnd =
              (imageButton.getWidth() - imageButtonTargetSize.x + imageButtonPadding.x) / 2;
          imageButtonDistance.x =
              getWidth() - imageButtonStart.x - imageButtonTargetSize.x - scaleOffsetEnd - imageButtonMargin;
          imageButtonDistance.y =
              getHeight() - imageButtonStart.y - imageButtonTargetSize.y - scaleOffsetY;
          break;
        default:
          imageButtonDistance.x = 0;
          imageButtonDistance.y = 0;
          break;
      }
    }
  };

  class OnOffsetChangedListener implements AppBarLayout.OnOffsetChangedListener {

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
      final int scrollRange = appBarLayout.getTotalScrollRange();
      float scrollProgress = 1 - (((float) scrollRange + (float) verticalOffset) / scrollRange);

      if (imageButton != null) {
        imageButton.setScaleX(1 - imageButtonScaleDistance * scrollProgress);
        imageButton.setScaleY(1 - imageButtonScaleDistance * scrollProgress);

        imageButton.setX(imageButtonStart.x + ((imageButtonDistance.x) * scrollProgress));
        imageButton.setY(imageButtonStart.y + ((imageButtonDistance.y) * scrollProgress));
      }

      if (linearLayout != null) {
        linearLayout.setAlpha(1 - (scrollProgress));
      }
    }
  }
}
