package com.ducdungdam.dartfriends.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.adapter.NextPlayerAdapter;
import com.ducdungdam.dartfriends.adapter.ScoreboardAdapter;
import com.ducdungdam.dartfriends.adapter.ScoreboardAdapter.OnScoreClickListener;
import com.ducdungdam.dartfriends.databinding.ActivityGameBinding;
import com.ducdungdam.dartfriends.model.RoundScore;
import com.ducdungdam.dartfriends.model.Score;
import com.ducdungdam.dartfriends.utilities.FakeDataUtils;
import com.ducdungdam.dartfriends.viewmodel.GameViewModel;

public class GameActivity extends AppCompatActivity implements OnScoreClickListener {

  ActivityGameBinding rootView;
  GameViewModel gameViewModel;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    rootView = DataBindingUtil.setContentView(this, R.layout.activity_game);
    setSupportActionBar(rootView.toolbar);

    // Data
    gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
    gameViewModel.setPlayerList(FakeDataUtils.getPlayerList());

    gameViewModel.getCurrentPlayerIndex().observe(this, new Observer<Integer>() {
      @Override
      public void onChanged(@Nullable Integer integer) {
        Log.d("DUNG", "onChanged: " + gameViewModel.getPlayer().toString());
        rootView.setPlayer(gameViewModel.getPlayer());
        rootView.setPoints(gameViewModel.getCurrentPlayerPoint());
      }
    });

    gameViewModel.getCurrentThrowIndex().observe(this, new Observer<Integer>() {
      @Override
      public void onChanged(@Nullable Integer integer) {
        rootView.setCurrentThrowIndex(integer);
      }
    });

    gameViewModel.getCurrentRoundScore().observe(this, new Observer<RoundScore>() {
      @Override
      public void onChanged(@Nullable RoundScore roundScore) {
        rootView.setCurrentRoundScore(roundScore);
      }
    });

    rootView.firstScore.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        gameViewModel.setCurrentThrowIndex(0);
      }
    });

    rootView.secondScore.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        gameViewModel.setCurrentThrowIndex(1);
      }
    });

    rootView.thirdScore.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        gameViewModel.setCurrentThrowIndex(2);
      }
    });


    rootView.rvNextPlayer.setAdapter(new NextPlayerAdapter(FakeDataUtils.getPlayerList()));
    new PagerSnapHelper().attachToRecyclerView(rootView.rvNextPlayer);

    rootView.rvScoreboard.setLayoutManager(new GridLayoutManager(GameActivity.this, 3));
    ScoreboardAdapter scoreboardAdapter = new ScoreboardAdapter();
    scoreboardAdapter.setOnScoreClickListener(this);
    rootView.rvScoreboard.setAdapter(scoreboardAdapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_game_menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_game_history:
        //TODO SHOW GAME HISTORY HERE
        return true;
      case R.id.menu_game_exit:
        alertDialog();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed() {
    alertDialog();
  }

  public void alertDialog() {
    new AlertDialog.Builder(this)
        .setTitle("Leave game")
        .setMessage(
            "You are about to leave an ongoing game. If you do so, all data of this game will no be saved.\nAre you sure?")
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            finish();
          }
        })
        .setNegativeButton("Abort", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        })
        .show();
  }

  @Override
  public void onScoreClick(Score score) {
    //TODO REWORK and implement with livedata

    if (true) { //Matches win condition depending on game mode?
      // points == 0
      //endGameShowOverview()
      //writeDataToDatabase()
    } else if (true) { //Matches fail condition?
      // points < 0
      //showFabNextPlayer()
    } else if (true) { //Matches next player condition?
      // roundScore throws == 3
      //showFabNextPlayer()
    } else if (true) { //Matches next throw condition condition?

      //setScore()
    }

    gameViewModel.setCurrentRoundScore(score);
//    gameViewModel.nextPlayer();
  }
}
