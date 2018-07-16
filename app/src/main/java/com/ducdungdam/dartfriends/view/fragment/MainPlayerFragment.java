package com.ducdungdam.dartfriends.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.adapter.PlayerAdapter;
import com.ducdungdam.dartfriends.databinding.FragmentMainPlayerBinding;
import com.ducdungdam.dartfriends.model.Player;
import com.ducdungdam.dartfriends.viewmodel.MainPlayerViewModel;
import java.util.List;


public class MainPlayerFragment extends Fragment {
  private FragmentMainPlayerBinding rootView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    rootView = DataBindingUtil.inflate(inflater, R.layout.fragment_main_player, container, false);

    final AppCompatActivity activity = (AppCompatActivity) getActivity();
    MainPlayerViewModel vm = ViewModelProviders.of(activity).get(MainPlayerViewModel.class);
    vm.getPlayerList().observe(activity, new Observer<List<Player>>() {
      @Override
      public void onChanged(@Nullable List<Player> players) {
        RecyclerView rv = rootView.rvPlayerStatistics;
        if (rv.getAdapter() == null) {
          PlayerAdapter adapter = new PlayerAdapter(players);
          rv.setAdapter(adapter);
        } else {
          ((PlayerAdapter) rv.getAdapter()).setPlayerList(players);
        }
      }
    });

    return rootView.getRoot();
  }
}
