package com.ducdungdam.dartfriends.utilities;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.model.RoundScore;
import com.ducdungdam.dartfriends.utilities.GlideUtils.CircleTransformation;

public class DataBindingUtils {
  @BindingAdapter("dataBindingUtilsSetImage")
  public static void setImage(ImageView imageView, String url) {
    Context context = imageView.getContext();
    Glide.with(context)
        .load(url)
        .apply(new RequestOptions().placeholder(R.drawable.placeholder))
        .transition(new DrawableTransitionOptions().crossFade())
        .into(imageView);
  }

  @BindingAdapter("dataBindingUtilsSetImageCircle")
  public static void setImageCircle(ImageView imageView, String url) {
    Context context = imageView.getContext();
    Glide.with(context)
        .load(url)
        .apply(new RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .transform(new MultiTransformation<>(new FitCenter(), new CircleTransformation()))
        )
        .transition(new DrawableTransitionOptions().crossFade())
        .into(imageView);
  }

  public static String getScoreString(int index, RoundScore roundScore) {
    try{
      return roundScore.getScores().get(index).getString();
    } catch (Exception e) {
      return "-";
    }
  }
}
