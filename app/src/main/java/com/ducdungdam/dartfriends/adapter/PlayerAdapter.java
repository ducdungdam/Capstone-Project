package com.ducdungdam.dartfriends.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.adapter.PlayerAdapter.PlayerViewHolder;
import com.ducdungdam.dartfriends.databinding.ViewPlayerItemBinding;
import com.ducdungdam.dartfriends.model.User;
import java.util.List;

/**
 * Created by ducdungdam on 13.07.18.
 */


public class PlayerAdapter extends RecyclerView.Adapter<PlayerViewHolder> {

  private List<User> playerList;
  private OnPlayerSelectListener onPlayerSelectListener;

  public PlayerAdapter(List<User> playerList) {
    this.playerList = playerList;
  }

  @Override
  public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    View view = LayoutInflater.from(context)
        .inflate(R.layout.view_player_item, parent, false);
    return new PlayerViewHolder(view);
  }

  @Override
  public void onBindViewHolder(PlayerViewHolder holder, int position) {
    holder.bind(playerList.get(position));
  }

  @Override
  public int getItemCount() {
    return playerList.size();
  }

  public void setPlayerList(List<User> playerList) {
    this.playerList = playerList;
    notifyDataSetChanged();
  }

  public void setOnPlayerSelectListener(
      OnPlayerSelectListener onPlayerSelectListener) {
    this.onPlayerSelectListener = onPlayerSelectListener;
  }

  public interface OnPlayerSelectListener {
    void onPlayerSelect(User user);
  }

  class PlayerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ViewPlayerItemBinding rootView;

    public PlayerViewHolder(View itemView) {
      super(itemView);
      rootView = DataBindingUtil.bind(itemView);
      itemView.setOnClickListener(this);
    }

    public void bind(User user) {
      rootView.setUser(user);
    }

    @Override
    public void onClick(View view) {
    }
  }
}

