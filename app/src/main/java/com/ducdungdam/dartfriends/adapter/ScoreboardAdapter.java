package com.ducdungdam.dartfriends.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.databinding.ViewScoreboardScoreItemBinding;
import com.ducdungdam.dartfriends.databinding.ViewScoreboardMultiplierItemBinding;
import com.ducdungdam.dartfriends.model.Score;
import com.ducdungdam.dartfriends.model.ScoreMultiplier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducdungdam on 13.07.18.
 */

public class ScoreboardAdapter extends RecyclerView.Adapter<ViewHolder> {

  public static final int VIEW_TYPE_SCORE = 0;
  public static final int VIEW_TYPE_MULTIPLIER = 1;

  private List<Object> scoreBoardList = new ArrayList<>();
  private OnScoreClickListener onScoreClickListener;
  private int multiplierPosition = -1;

  public ScoreboardAdapter() {
    setHasStableIds(true);
    scoreBoardList.add(new ScoreMultiplier("Double", "D", 2));
    scoreBoardList.add(new ScoreMultiplier("Triple", "T", 3));
    scoreBoardList.add(new Score("Bull", 25));
    for (int i = 1; i <= 20; i++) {
      scoreBoardList.add(new Score(String.valueOf(i), i));
    }
    scoreBoardList.add(new Score("Miss", 0));
  }

  @Override
  @NonNull
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    switch (viewType) {
      case VIEW_TYPE_SCORE:
        return new ScoreViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.view_scoreboard_score_item, parent, false));
      case VIEW_TYPE_MULTIPLIER:
        return new MultiplierViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.view_scoreboard_multiplier_item, parent, false));
      default:
        throw new IllegalArgumentException("Invalid view type, value of " + viewType);
    }
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    if (holder instanceof ScoreViewHolder) {
      ((ScoreViewHolder) holder).bind((Score) scoreBoardList.get(position));
    } else if (holder instanceof MultiplierViewHolder) {
      ((MultiplierViewHolder) holder).bind((ScoreMultiplier) scoreBoardList.get(position));
      if (multiplierPosition == position) {
        Context context = holder.itemView.getContext();
        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
      } else {
        holder.itemView.setBackground(null);
      }
    }
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public int getItemViewType(int position) {
    Object item = scoreBoardList.get(position);
    if (item instanceof Score) {
      return VIEW_TYPE_SCORE;
    } else if (item instanceof ScoreMultiplier) {
      return VIEW_TYPE_MULTIPLIER;
    }
    return -1;
  }

  @Override
  public int getItemCount() {
    return scoreBoardList.size();
  }

  public void setOnScoreClickListener(OnScoreClickListener onScoreClickListener) {
    this.onScoreClickListener = onScoreClickListener;
  }

  public interface OnScoreClickListener {
    void onScoreClick(Score score);
  }

  class ScoreViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

    ViewScoreboardScoreItemBinding rootView;

    private ScoreViewHolder(View itemView) {
      super(itemView);
      rootView = DataBindingUtil.bind(itemView);
      itemView.setOnClickListener(this);
    }

    void bind(Score score) {
      rootView.setScore(score);
    }

    @Override
    public void onClick(View view) {
      Score score = rootView.getScore();
      if (score != null) {
        try {
          ScoreMultiplier scoreMultiplier = (ScoreMultiplier) scoreBoardList.get(multiplierPosition);
          score.setScoreMultiplier(scoreMultiplier);
        } catch (IndexOutOfBoundsException e) {
          Log.d("DUNG", "onClick: No Multiplier was chosen");
        }
        onScoreClickListener.onScoreClick(score);
      }
    }
  }

  class MultiplierViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

    ViewScoreboardMultiplierItemBinding rootView;

    private MultiplierViewHolder(View itemView) {
      super(itemView);
      rootView = DataBindingUtil.bind(itemView);
      itemView.setOnClickListener(this);
    }

    void bind(ScoreMultiplier multiplier) {
      rootView.setMultiplier(multiplier);
    }

    @Override
    public void onClick(View view) {
      ScoreMultiplier multiplier = rootView.getMultiplier();
      if (multiplier != null) {
        if (multiplierPosition == getAdapterPosition()) {
          multiplierPosition = -1;
        } else {
          multiplierPosition = getAdapterPosition();
        }
        notifyDataSetChanged();
      }
    }
  }
}
