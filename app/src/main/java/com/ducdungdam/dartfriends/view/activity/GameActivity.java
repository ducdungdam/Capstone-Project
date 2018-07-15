package com.ducdungdam.dartfriends.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.util.Log;
import android.view.Menu;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.adapter.NextPlayerAdapter;
import com.ducdungdam.dartfriends.adapter.ScoreboardAdapter;
import com.ducdungdam.dartfriends.adapter.ScoreboardAdapter.OnScoreClickListener;
import com.ducdungdam.dartfriends.databinding.ActivityGameBinding;
import com.ducdungdam.dartfriends.model.Score;
import com.ducdungdam.dartfriends.utilities.DataBindingUtils;
import com.ducdungdam.dartfriends.utilities.FakeDataUtils;

public class GameActivity extends AppCompatActivity {

  ActivityGameBinding rootView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    rootView = DataBindingUtil.setContentView(this, R.layout.activity_game);
    DataBindingUtils.setImageCircle(rootView.ivCurrentUser, FakeDataUtils.getUser().imageSrc);

    setSupportActionBar(rootView.toolbar);

//    rootView.rvNextPlayer.addItemDecoration(new NextPlayerItemDecoration(GameActivity.this));
    rootView.rvNextPlayer.setAdapter(new NextPlayerAdapter(FakeDataUtils.getUserList()));
    new PagerSnapHelper().attachToRecyclerView(rootView.rvNextPlayer);

    rootView.rvScoreboard.setLayoutManager(new GridLayoutManager(GameActivity.this, 3));

    ScoreboardAdapter scoreboardAdapter = new ScoreboardAdapter();
    scoreboardAdapter.setOnScoreClickListener(new OnScoreClickListener() {
      @Override
      public void onScoreClick(Score score, Score multiplier) {
        Log.d("DUNG", "onScoreClick: "+score.name);
        if (multiplier == null) {
          Log.d("DUNG", "multiplier: null");
        } else {
          Log.d("DUNG", "onScoreClick: "+multiplier.name);
        }
      }
    });
    rootView.rvScoreboard.setAdapter(scoreboardAdapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_game_menu, menu);
    return true;
  }
}
