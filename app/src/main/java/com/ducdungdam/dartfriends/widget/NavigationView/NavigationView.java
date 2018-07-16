package com.ducdungdam.dartfriends.widget.NavigationView;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.databinding.ViewNavigationBinding;
import com.ducdungdam.dartfriends.model.Player;

/**
 * Created by ducdungdam on 13.07.18.
 */

public class NavigationView extends CoordinatorLayout {

  private ViewNavigationBinding root;
  OnItemSelectedListener onItemSelectedListener;

  public NavigationView(Context context) {
    this(context, null);
  }

  public NavigationView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public NavigationView(Context context, AttributeSet attrs,
      int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    root = DataBindingUtil
        .inflate(LayoutInflater.from(context), R.layout.view_navigation, this, true);
  }

  public void setPlayer(Player player) {
    root.setPlayer(player);
  }

  public void setAdapter(NavigationViewAdapter navigationViewAdapter) {
    root.content.rvNavigationContent.setAdapter(navigationViewAdapter);
    root.content.rvNavigationContent.addItemDecoration(new NavigationItemDecoration(getContext()));

  }

  public void setOnItemSelectedListener(final OnItemSelectedListener onItemSelectedListener) {
    this.onItemSelectedListener = onItemSelectedListener;
    ((NavigationViewAdapter) root.content.rvNavigationContent.getAdapter()).setOnItemClickListener(
        new NavigationViewAdapter.OnItemSelectedListener() {
          @Override
          public void onItemSelected(int position) {
            onItemSelectedListener.onItemSelected(position);
          }
        }
    );
  }

  public interface OnItemSelectedListener {

    void onItemSelected(int position);
  }
}
