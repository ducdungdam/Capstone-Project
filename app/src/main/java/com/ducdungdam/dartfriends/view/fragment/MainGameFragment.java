package com.ducdungdam.dartfriends.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.adapter.GameModeAdapter;
import com.ducdungdam.dartfriends.adapter.PlayerSelectionAdapter;
import com.ducdungdam.dartfriends.adapter.PlayerSelectionAdapter.OnPlayerSelectListener;
import com.ducdungdam.dartfriends.databinding.FragmentMainGameBinding;
import com.ducdungdam.dartfriends.model.GameMode;
import com.ducdungdam.dartfriends.model.Player;
import com.ducdungdam.dartfriends.view.activity.GameActivity;
import com.ducdungdam.dartfriends.viewmodel.MainGameViewModel;
import com.ducdungdam.dartfriends.widget.GameModeItemDecoration;
import com.ducdungdam.dartfriends.widget.PlayerSelectionItemDecoration;
import java.util.List;


public class MainGameFragment extends Fragment implements OnPlayerSelectListener {

  private FragmentMainGameBinding rootView;
  private Snackbar snackbar;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    rootView = DataBindingUtil.inflate(inflater, R.layout.fragment_main_game, container, false);

    final AppCompatActivity activity = (AppCompatActivity) getActivity();
    MainGameViewModel vm = ViewModelProviders.of(activity).get(MainGameViewModel.class);

    vm.getGameModeList().observe(activity, new Observer<List<GameMode>>() {
      @Override
      public void onChanged(@Nullable List<GameMode> gameModes) {
        RecyclerView rv = rootView.rvGameModeSelection;
        if (rv.getAdapter() == null) {
          rv.addItemDecoration(new GameModeItemDecoration(getActivity()));
          rv.setOnFlingListener(null);
          new PagerSnapHelper().attachToRecyclerView(rv);
          rv.setAdapter(new GameModeAdapter(gameModes));
        } else {
          ((GameModeAdapter) rv.getAdapter()).setGameModeList(gameModes);
        }
      }
    });

    vm.getPlayerList().observe(activity, new Observer<List<Player>>() {
      @Override
      public void onChanged(@Nullable List<Player> players) {
        RecyclerView rv = rootView.rvPlayerSelection;
        if (rv.getAdapter() == null) {
          int columnCount = 3;
          rv.setLayoutManager(new GridLayoutManager(activity, columnCount));
          rv.addItemDecoration(new PlayerSelectionItemDecoration(activity));
          PlayerSelectionAdapter adapter = new PlayerSelectionAdapter(players);
          adapter.setOnPlayerSelectListener(MainGameFragment.this);
          rv.setAdapter(adapter);
        } else {
          ((PlayerSelectionAdapter) rv.getAdapter()).setPlayerList(players);
        }
      }
    });

    return rootView.getRoot();
  }

  @Override
  public void onPlayerSelect(Player player) {

    PlayerSelectionAdapter adapter = (PlayerSelectionAdapter) rootView.rvPlayerSelection
        .getAdapter();
    if (adapter != null && adapter.getSelectedPlayer().size() > 0) {
      if (snackbar == null) {
        snackbar = Snackbar
            .make(rootView.constraintLayout,
                String.format("Start game with %s player(s)", adapter.getSelectedPlayer().size()),
                Snackbar.LENGTH_INDEFINITE)
            .setAction("Start", new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GameActivity.class);
                startActivity(intent);
              }
            });
        snackbar.show();
      } else {
        snackbar.setText(
            String.format("Start game with %s player(s)", adapter.getSelectedPlayer().size()));
      }
    } else if (snackbar != null) {
      snackbar.dismiss();
      snackbar = null;
    }
  }

  @Override
  public void onResume() {
    super.onResume();
//    rootView.getRoot().scrollTo(0,0);
//    PlayerSelectionAdapter adapter = (PlayerSelectionAdapter) rootView.rvPlayerSelection.getAdapter();
//    if (adapter != null) {
//      adapter.resetSelectedPlayer();
//    }
  }
}
