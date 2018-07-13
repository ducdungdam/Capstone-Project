package com.ducdungdam.dartfriends.view.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.databinding.FragmentMainHelpCenterBinding;


public class MainHelpCenterFragment extends Fragment {
  private FragmentMainHelpCenterBinding rootView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    rootView = DataBindingUtil
        .inflate(inflater, R.layout.fragment_main_help_center, container, false);
    return rootView.getRoot();
  }
}
