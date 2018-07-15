package com.ducdungdam.dartfriends.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.adapter.ScoreboardAdapter.ScoreViewHolder;
import com.ducdungdam.dartfriends.databinding.ViewScoreboardItemBinding;
import com.ducdungdam.dartfriends.model.Score;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducdungdam on 13.07.18.
 */

public class ScoreboardAdapter extends RecyclerView.Adapter<ScoreViewHolder> {

  private List<Score> scoreList = new ArrayList<>();
  private OnScoreClickListener onScoreClickListener;
  private Score multiplier = null;

  public ScoreboardAdapter() {
    scoreList.add(new Score("Double", 2, Score.TYPE_MULTIPLIER));
    scoreList.add(new Score("Triple", 3, Score.TYPE_MULTIPLIER));
    scoreList.add(new Score("Bull", 25, Score.TYPE_SCORE));
    for (int i = 1; i <= 20; i++) {
      scoreList.add(new Score(String.valueOf(i), i, Score.TYPE_SCORE));
    }
    scoreList.add(new Score("Miss", 0, Score.TYPE_SCORE));
  }

  @Override
  public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    return new ScoreViewHolder(
        LayoutInflater.from(context)
            .inflate(R.layout.view_scoreboard_item, parent, false));
  }

  @Override
  public void onBindViewHolder(ScoreViewHolder holder, int position) {
    holder.bind(scoreList.get(position));
  }


  @Override
  public int getItemCount() {
    return scoreList.size();
  }

  public void setOnScoreClickListener(OnScoreClickListener onScoreClickListener) {
    this.onScoreClickListener = onScoreClickListener;
  }

  public interface OnScoreClickListener {
    void onScoreClick(Score score, Score multiplier);
  }

  class ScoreViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

    ViewScoreboardItemBinding rootView;

    public ScoreViewHolder(View itemView) {
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
      if (score != null)
        switch (score.type) {
          case Score.TYPE_SCORE:
            onScoreClickListener.onScoreClick(score, multiplier);
            break;
          case Score.TYPE_MULTIPLIER:
            if (multiplier == null) {
              view.setBackgroundColor(view.getContext().getResources().getColor(R.color.colorAccent));
            } else if (score.name.equals(multiplier.name)){
              view.setBackgroundColor(view.getContext().getResources().getColor(android.R.color.transparent));
            } else {
              view.setBackgroundColor(view.getContext().getResources().getColor(R.color.colorAccent));
            }
            break; 
        }
    }
  }
}
