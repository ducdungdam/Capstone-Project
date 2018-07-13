package com.ducdungdam.dartfriends.widget.NavigationView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.utilities.UnitConverterUtils;

/**
 * Created by ducdungdam on 13.07.18.
 */

public class NavigationItemDecoration extends ItemDecoration {

  private final Paint paint;
  private int dividerHeight;
  private int paddingLeft;
  private int paddingTop;
  private int paddingRight;
  private int paddingBottom;
  private int paddingDivider;

  public NavigationItemDecoration(Context context) {
    this(context, context.getResources().getColor(R.color.colorAccent), 1);
  }

  public NavigationItemDecoration(Context context, int color, int dividerHeight) {
    paint = new Paint();
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(color);
    this.dividerHeight = (int) UnitConverterUtils.dpToPx(context.getResources(), dividerHeight);

    paddingLeft = (int) context.getResources().getDimension(R.dimen.spacing_huge);
    paddingTop = (int) context.getResources().getDimension(R.dimen.spacing_appbar);
    paddingRight = (int) context.getResources().getDimension(R.dimen.spacing_huge);
    paddingBottom = (int) context.getResources().getDimension(R.dimen.spacing_appbar);

    paddingDivider = (int) UnitConverterUtils.dpToPx(context.getResources(), 20);
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
      RecyclerView.State state) {

    int viewPaddingLeft = paddingLeft;
    int viewPaddingTop = paddingTop;
    int viewPaddingRight = paddingRight;
    int viewPaddingBottom = paddingBottom;

    int position = parent.getChildAdapterPosition(view);
    int viewType = parent.getAdapter().getItemViewType(position);

    // Set Padding
    if (position == 0) {
      viewPaddingTop = viewPaddingTop * 2;
    }

    // Check for Previous Divider
    if (position - 1 >= 0) {
      int prevViewType = parent.getAdapter().getItemViewType(position - 1);
      if (viewType != prevViewType) {
        View prevView = parent.getChildAt(position - 1);
        prevView.setPadding(
            prevView.getPaddingLeft(),
            prevView.getPaddingTop(),
            prevView.getPaddingRight(),
            prevView.getPaddingBottom() * 2
        );
        viewPaddingTop = viewPaddingTop * 2;
      }
    }

    // TODO: We should only set outRect with dividerHeight, if one is drawn. Since getItemOffers is called while RecyclcerView creates its item, we cant access on the Next View to detect, wether we need to draw an Divider.
    outRect.set(0, 0, 0, dividerHeight);
    view.setPadding(viewPaddingLeft, viewPaddingTop, viewPaddingRight, viewPaddingBottom);
  }

  @Override
  public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
    for (int i = 0; i < parent.getChildCount(); i++) {
      View view = parent.getChildAt(i);
      int position = parent.getChildAdapterPosition(view);
      int viewType = parent.getAdapter().getItemViewType(position);

      // Check for Current Divider
      if (position + 1 < parent.getChildCount()) {
        int nextViewType = parent.getAdapter().getItemViewType(position + 1);
        if (viewType != nextViewType) {
          c.drawRect(
              view.getLeft() + paddingDivider,
              view.getBottom(),
              view.getRight() - paddingDivider,
              view.getBottom() + dividerHeight,
              paint
          );
        }
      }
    }
  }
}
