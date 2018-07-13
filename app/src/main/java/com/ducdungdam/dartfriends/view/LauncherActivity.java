package com.ducdungdam.dartfriends.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by damdu on 13.07.2018.
 */

public class LauncherActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //TODO: check user exist

    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
    if (true) {
      intent = new Intent(getApplicationContext(), CreatePlayerActivity.class);
    }
    startActivity(intent);
    finish();
  }
}
