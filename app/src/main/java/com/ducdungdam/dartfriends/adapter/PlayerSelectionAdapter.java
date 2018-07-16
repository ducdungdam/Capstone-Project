package com.ducdungdam.dartfriends.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.adapter.PlayerSelectionAdapter.PlayerSelectionViewHolder;
import com.ducdungdam.dartfriends.databinding.ViewPlayerSelectionItemBinding;
import com.ducdungdam.dartfriends.model.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducdungdam on 13.07.18.
 */


public class PlayerSelectionAdapter extends RecyclerView.Adapter<PlayerSelectionViewHolder> {

  private List<Player> playerList;
  private List<Integer> selectedPlayer = new ArrayList<>();
  private OnPlayerSelectListener onPlayerSelectListener;

  public PlayerSelectionAdapter(List<Player> playerList) {
    this.playerList = playerList;
  }

  @Override
  public PlayerSelectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    View view = LayoutInflater.from(context)
        .inflate(R.layout.view_player_selection_item, parent, false);
    return new PlayerSelectionViewHolder(view);
  }

  @Override
  public void onBindViewHolder(PlayerSelectionViewHolder holder, int position) {
    holder.bind(playerList.get(position));
  }

  @Override
  public int getItemCount() {
    return playerList.size();
  }

  public void setPlayerList(List<Player> playerList) {
    this.playerList = playerList;
    notifyDataSetChanged();
  }

  public List<Integer> getSelectedPlayer() {
    return selectedPlayer;
  }

  public void resetSelectedPlayer(){
    selectedPlayer = new ArrayList<>();
    notifyDataSetChanged();
  }

  public void setOnPlayerSelectListener(
      OnPlayerSelectListener onPlayerSelectListener) {
    this.onPlayerSelectListener = onPlayerSelectListener;
  }

  public interface OnPlayerSelectListener {
    void onPlayerSelect(Player player);
  }

  class PlayerSelectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ViewPlayerSelectionItemBinding rootView;

    public PlayerSelectionViewHolder(View itemView) {
      super(itemView);
      rootView = DataBindingUtil.bind(itemView);
      itemView.setOnClickListener(this);
    }

    public void bind(Player player) {
      rootView.setPlayer(player);
    }

    @Override
    public void onClick(View view) {
      Player player = rootView.getPlayer();
      if (rootView.ivUserOverlay.getVisibility() != View.VISIBLE) {
        selectedPlayer.add(player.id);
        rootView.tvUserOverlayCounter.setText(String.valueOf(selectedPlayer.size()));
        rootView.ivUserOverlay.setVisibility(View.VISIBLE);
      } else if (player.id == selectedPlayer.get(selectedPlayer.size() - 1)) {
        selectedPlayer.remove(selectedPlayer.size() - 1);
        rootView.ivUserOverlay.setVisibility(View.INVISIBLE);
      }
      if (onPlayerSelectListener != null) {
        onPlayerSelectListener.onPlayerSelect(player);
      }
    }
  }
}

