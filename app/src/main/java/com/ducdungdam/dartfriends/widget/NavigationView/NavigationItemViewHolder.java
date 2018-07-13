package com.ducdungdam.dartfriends.widget.NavigationView;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewItem.MainNavigationViewItem;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewItem.OtherNavigationViewItem;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewItem.SubNavigationViewItem;
import com.ducdungdam.dartfriends.databinding.ViewNavigationItemMainBinding;
import com.ducdungdam.dartfriends.databinding.ViewNavigationItemSubBinding;
import com.ducdungdam.dartfriends.databinding.ViewNavigationItemOtherBinding;

/**
 * Created by ducdungdam on 13.07.18.
 */

public abstract class NavigationItemViewHolder extends RecyclerView.ViewHolder {

  OnItemClickListener onItemClickListener;
  public int highlightColor;
  public int defaultColor;

  public NavigationItemViewHolder(View itemView) {
    super(itemView);
    defaultColor = itemView.getContext().getResources().getColor(R.color.colorSecondaryText);
    highlightColor = itemView.getContext().getResources().getColor(R.color.colorPrimaryText);
    itemView.setOnClickListener(onClickListener);
  }

  OnClickListener onClickListener = new OnClickListener() {
    @Override
    public void onClick(View view) {
      onItemClickListener.onClick(view);
    }
  };


  public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    this.onItemClickListener = onItemClickListener;
  }

  interface OnItemClickListener {

    void onClick(View view);
  }

  public abstract void bind(NavigationViewItem item);

  public abstract void setHighlight();


  public static class MainItemViewHolder extends NavigationItemViewHolder {

    private ViewNavigationItemMainBinding root;

    public MainItemViewHolder(View mainItemView) {
      super(mainItemView);
      root = DataBindingUtil.bind(itemView);
    }

    @Override
    public void bind(NavigationViewItem item) {
      root.title.setTypeface(root.title.getTypeface(), Typeface.NORMAL);
      root.title.setTextColor(defaultColor);
      root.icon.setColorFilter(defaultColor);
      root.setMainItem((MainNavigationViewItem) item);
    }

    @Override
    public void setHighlight() {
      root.title.setTypeface(root.title.getTypeface(), Typeface.BOLD);
      root.title.setTextColor(highlightColor);
      root.icon.setColorFilter(highlightColor);
    }
  }

  public static class SubItemViewHolder extends NavigationItemViewHolder {

    private ViewNavigationItemSubBinding root;

    public SubItemViewHolder(View subItemView) {
      super(subItemView);
      root = DataBindingUtil.bind(subItemView);
    }

    @Override
    public void bind(NavigationViewItem item) {
      root.title.setTypeface(root.title.getTypeface(), Typeface.NORMAL);
      root.title.setTextColor(defaultColor);
      root.icon.setColorFilter(defaultColor);
      root.setSubItem((SubNavigationViewItem) item);
    }

    @Override
    public void setHighlight() {
      root.title.setTypeface(root.title.getTypeface(), Typeface.BOLD);
      root.title.setTextColor(highlightColor);
      root.icon.setColorFilter(highlightColor);
    }
  }

  public static class OtherItemViewHolder extends NavigationItemViewHolder {

    private ViewNavigationItemOtherBinding root;

    public OtherItemViewHolder(View otherItemView) {
      super(otherItemView);
      root = DataBindingUtil.bind(otherItemView);
    }

    @Override
    public void bind(NavigationViewItem item) {
      root.title.setTypeface(root.title.getTypeface(), Typeface.NORMAL);
      root.title.setTextColor(defaultColor);
      root.setOtherItem((OtherNavigationViewItem) item);
    }

    @Override
    public void setHighlight() {
      root.title.setTypeface(root.title.getTypeface(), Typeface.BOLD);
      root.title.setTextColor(highlightColor);
    }
  }
}
