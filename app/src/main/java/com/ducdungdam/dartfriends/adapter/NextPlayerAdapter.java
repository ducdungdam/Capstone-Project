package com.ducdungdam.dartfriends.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.adapter.NextPlayerAdapter.NextPlayerViewHolder;
import com.ducdungdam.dartfriends.databinding.ViewNextPlayerItemBinding;
import com.ducdungdam.dartfriends.model.Player;
import java.util.List;

/**
 * Created by ducdungdam on 13.07.18.
 */

public class NextPlayerAdapter extends RecyclerView.Adapter<NextPlayerViewHolder> {

  private List<Player> playerList;

  public NextPlayerAdapter(List<Player> playerList) {
    this.playerList = playerList;
  }

  @Override
  public NextPlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    View view = LayoutInflater.from(context)
        .inflate(R.layout.view_next_player_item, parent, false);
    return new NextPlayerViewHolder(view);
  }

  @Override
  public void onBindViewHolder(NextPlayerViewHolder holder, int position) {
    holder.bind(playerList.get(position));
  }

  @Override
  public int getItemCount() {
    return playerList.size();
  }

  class NextPlayerViewHolder extends RecyclerView.ViewHolder {

    ViewNextPlayerItemBinding rootView;

    public NextPlayerViewHolder(View itemView) {
      super(itemView);
      rootView = DataBindingUtil.bind(itemView);
    }

    void bind(Player player){
      rootView.setPlayer(player);
    }
  }
}
