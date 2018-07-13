package com.ducdungdam.dartfriends.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{
  ActivityMainBinding rootView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    rootView = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
  }
}
