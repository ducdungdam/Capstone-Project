package com.ducdungdam.dartfriends.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.adapter.GameModeAdapter.GameModeViewHolder;
import com.ducdungdam.dartfriends.databinding.ViewGameModeItemBinding;
import com.ducdungdam.dartfriends.model.GameMode;
import java.util.List;

/**
 * Created by ducdungdam on 13.07.18.
 */

public class GameModeAdapter extends RecyclerView.Adapter<GameModeViewHolder> {
  private List<GameMode> gameModeList;

  public GameModeAdapter(List<GameMode> gameModeList) {
    this.gameModeList = gameModeList;
  }

  @Override
  public GameModeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    View view = LayoutInflater.from(context)
        .inflate(R.layout.view_game_mode_item, parent, false);
    return new GameModeViewHolder(view);
  }

  @Override
  public void onBindViewHolder(GameModeViewHolder holder, int position) {
    holder.bind(gameModeList.get(position));
  }

  @Override
  public int getItemCount() {
    return gameModeList.size();
  }

  public void setGameModeList(List<GameMode> gameModeList) {
    this.gameModeList = gameModeList;
    notifyDataSetChanged();
  }

  class GameModeViewHolder extends RecyclerView.ViewHolder {

    ViewGameModeItemBinding rootView;

    public GameModeViewHolder(View itemView) {
      super(itemView);
      rootView = DataBindingUtil.bind(itemView);
    }

    void bind(GameMode gameMode){
      rootView.setGameMode(gameMode);
    }
  }
}
