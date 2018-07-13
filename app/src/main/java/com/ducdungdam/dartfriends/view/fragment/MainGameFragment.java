package com.ducdungdam.dartfriends.view.fragment;

import android.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.ducdungdam.dartfriends.databinding.FragmentMainGameBinding;
import com.ducdungdam.dartfriends.model.GameMode;
import com.ducdungdam.dartfriends.model.User;
import com.ducdungdam.dartfriends.viewmodel.GameViewModel;
import com.ducdungdam.dartfriends.widget.GameModeItemDecoration;
import com.ducdungdam.dartfriends.widget.PlayerSelectionItemDecoration;
import java.util.List;


public class MainGameFragment extends Fragment {

  private FragmentMainGameBinding rootView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    rootView = DataBindingUtil.inflate(inflater, R.layout.fragment_main_game, container, false);

    final AppCompatActivity activity = (AppCompatActivity) getActivity();
    GameViewModel vm = ViewModelProviders.of(activity).get(GameViewModel.class);

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

    vm.getUserList().observe(activity, new Observer<List<User>>() {
      @Override
      public void onChanged(@Nullable List<User> users) {
        RecyclerView rv = rootView.rvPlayerSelection;
        if (rv.getAdapter() == null) {
          int columnCount = 3;
          rv.setLayoutManager(new GridLayoutManager(activity, columnCount));
          rv.addItemDecoration(new PlayerSelectionItemDecoration(activity));
          rv.setAdapter(new PlayerSelectionAdapter(users));
        } else {
          ((PlayerSelectionAdapter) rv.getAdapter()).setPlayerList(users);

        }
      }
    });

    return rootView.getRoot();
  }
}
