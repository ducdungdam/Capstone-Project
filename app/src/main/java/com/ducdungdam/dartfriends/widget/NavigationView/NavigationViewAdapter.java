package com.ducdungdam.dartfriends.widget.NavigationView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationItemViewHolder.MainItemViewHolder;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationItemViewHolder.OnItemClickListener;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationItemViewHolder.OtherItemViewHolder;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationItemViewHolder.SubItemViewHolder;
import java.util.List;

/**
 * Created by ducdungdam on 13.07.18.
 */

public class NavigationViewAdapter extends
    RecyclerView.Adapter<NavigationItemViewHolder> {

  final static int MAIN = 0;
  final static int SUB = 1;
  final static int OTHER = 2;

  private int selectedPosition;

  private List<? extends NavigationViewItem> navigationViewItems;
  private OnItemSelectedListener onItemSelectedListener;

  public NavigationViewAdapter(List<? extends NavigationViewItem> navigationViewItems) {
    this.navigationViewItems = navigationViewItems;
  }

  @Override
  public int getItemCount() {
    return navigationViewItems == null ? 0 : navigationViewItems.size();
  }

  @Override
  public NavigationItemViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
    switch (viewType) {
      case MAIN:
        View mainItemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.view_navigation_item_main, parent, false);
        MainItemViewHolder mainItemViewHolder = new MainItemViewHolder(mainItemView);
        mainItemViewHolder.setOnItemClickListener(new OnItemClickListener() {
          @Override
          public void onClick(View view) {
            int position = ((RecyclerView) parent).getChildAdapterPosition(view);
            selectedPosition = position;
            notifyDataSetChanged();
            if (onItemSelectedListener != null) {
              onItemSelectedListener.onItemSelected(position);
            }
          }
        });
        return mainItemViewHolder;
      case SUB:
        View subItemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.view_navigation_item_sub, parent, false);
        SubItemViewHolder subItemViewHolder = new SubItemViewHolder(subItemView);
        subItemViewHolder.setOnItemClickListener(new OnItemClickListener() {
          @Override
          public void onClick(View view) {
            int position = ((RecyclerView) parent).getChildAdapterPosition(view);
            selectedPosition = position;
            notifyDataSetChanged();
            if (onItemSelectedListener != null) {
              onItemSelectedListener.onItemSelected(position);
            }
          }
        });
        return subItemViewHolder;
      case OTHER:
        View otherItemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.view_navigation_item_other, parent, false);
        OtherItemViewHolder otherItemViewHolder = new OtherItemViewHolder(otherItemView);
        otherItemViewHolder.setOnItemClickListener(new OnItemClickListener() {
          @Override
          public void onClick(View view) {
            int position = ((RecyclerView) parent).getChildAdapterPosition(view);
            if (onItemSelectedListener != null) {
              onItemSelectedListener.onItemSelected(position);
            }
          }
        });
        return otherItemViewHolder;
    }
    return null;
  }

  @Override
  public int getItemViewType(int position) {
    switch (navigationViewItems.get(position).type) {
      case MAIN:
        return this.MAIN;
      case SUB:
        return this.SUB;
      case OTHER:
        return this.OTHER;
      default:
        return -1;
    }
  }

  @Override
  public void onBindViewHolder(NavigationItemViewHolder holder, int position) {
    NavigationViewItem item = navigationViewItems.get(position);
    holder.bind(item);
    if (selectedPosition == position) {
      holder.setHighlight();
    }
  }

  public void setOnItemClickListener(OnItemSelectedListener onItemSelectedListener) {
    this.onItemSelectedListener = onItemSelectedListener;
  }

  interface OnItemSelectedListener {

    void onItemSelected(int position);
  }
}