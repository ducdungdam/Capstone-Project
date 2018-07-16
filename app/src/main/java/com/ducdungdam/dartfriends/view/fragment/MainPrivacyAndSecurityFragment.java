package com.ducdungdam.dartfriends.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.databinding.FragmentMainPrivacyAndSecurityBinding;
import com.ducdungdam.dartfriends.utilities.DataBindingUtils;


public class MainPrivacyAndSecurityFragment extends Fragment {
  private FragmentMainPrivacyAndSecurityBinding rootView;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    rootView = DataBindingUtil
        .inflate(inflater, R.layout.fragment_main_privacy_and_security, container, false);
    DataBindingUtils.setImage(rootView.imageView4, "https://banner2.kisspng.com/20180206/ltw/kisspng-bar-chart-icon-bar-graph-icon-5a79661a925642.5502184915179054345994.jpg");
    DataBindingUtils.setImage(rootView.imageView5, "https://banner2.kisspng.com/20171216/dc5/email-png-5a359002d41e30.0549982615134597148688.jpg");
    return rootView.getRoot();
  }
}
