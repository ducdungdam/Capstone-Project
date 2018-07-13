package com.ducdungdam.dartfriends.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.databinding.ActivityCreatePlayerBinding;

public class CreatePlayerActivity extends AppCompatActivity {

  ActivityCreatePlayerBinding rootView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    rootView = DataBindingUtil.setContentView(this, R.layout.activity_create_player);

    rootView.button.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(CreatePlayerActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
      }
    });
  }
}
