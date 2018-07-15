package com.ducdungdam.dartfriends.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.databinding.ActivityMainBinding;
import com.ducdungdam.dartfriends.model.User;
import com.ducdungdam.dartfriends.view.fragment.MainAchievementsFragment;
import com.ducdungdam.dartfriends.view.fragment.MainGameFragment;
import com.ducdungdam.dartfriends.view.fragment.MainHelpCenterFragment;
import com.ducdungdam.dartfriends.view.fragment.MainHistoryFragment;
import com.ducdungdam.dartfriends.view.fragment.MainImprintFragment;
import com.ducdungdam.dartfriends.view.fragment.MainPlayerFragment;
import com.ducdungdam.dartfriends.view.fragment.MainPrivacyAndSecurityFragment;
import com.ducdungdam.dartfriends.view.fragment.MainSettingsFragment;
import com.ducdungdam.dartfriends.viewmodel.MainViewModel;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationView;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationView.OnItemSelectedListener;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewAdapter;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding rootView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    rootView = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

    setSupportActionBar(rootView.appbar.toolbar);
    ActionBar actionbar = getSupportActionBar();
    actionbar.setDisplayHomeAsUpEnabled(true);
    actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
    // Data
    MainViewModel vm = ViewModelProviders.of(this).get(MainViewModel.class);

    // NavigationView
    rootView.navigationView
        .setAdapter(new NavigationViewAdapter(vm.getNavigationViewItemList()));
    rootView.navigationView.setOnItemSelectedListener(onNavigationItemSelectedListener);

    vm.getUser().observe(this, new Observer<User>() {
      @Override
      public void onChanged(@Nullable User user) {
        rootView.setUser(user);
      }
    });

    //Set Fragment
    onNavigationItemSelectedListener.onItemSelected(0);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        rootView.navigationDrawer.openDrawer(GravityCompat.START);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed() {
    boolean isOpen = rootView.navigationDrawer.isDrawerOpen(GravityCompat.START);
    if (isOpen) {
      rootView.navigationDrawer.closeDrawers();
    } else {
      super.onBackPressed();
    }
  }

  /**
   * NavigationView.OnItemSelectedListener Implementation
   * Handles onClick from NavigationDrawer
   * Items are initiated here: {@link MainViewModel#getNavigationViewItemList()}
   */
  private NavigationView.OnItemSelectedListener onNavigationItemSelectedListener = new OnItemSelectedListener() {
    @Override
    public void onItemSelected(int position) {
      rootView.navigationDrawer.closeDrawers();
      Fragment f;
      switch (position) {
        case 0:
          rootView.appbar.collapsingToolbar.setTitle("Start Game");
          f = new MainGameFragment();
          break;
        case 1:
          f = new MainPlayerFragment();
          rootView.appbar.collapsingToolbar.setTitle("Player Statistics");
          break;
        case 2:
          f = new MainHistoryFragment();
          rootView.appbar.collapsingToolbar.setTitle("Game History");
          break;
        case 3:
          f = new MainAchievementsFragment();
          rootView.appbar.collapsingToolbar.setTitle("Achievements");
          break;
        case 4:
          f = new MainSettingsFragment();
          rootView.appbar.collapsingToolbar.setTitle("Settings");
          break;
        case 5:
          f = new MainPrivacyAndSecurityFragment();
          rootView.appbar.collapsingToolbar.setTitle("Privacy and Security");
          break;
        case 6:
          f = new MainHelpCenterFragment();
          rootView.appbar.collapsingToolbar.setTitle("Help Center");
          break;
        case 7:
          f = new MainImprintFragment();
          rootView.appbar.collapsingToolbar.setTitle("Imprint");
          break;
        default:
          throw new IllegalArgumentException("Fragment for " + position + " not define yet!");
      }
      getSupportFragmentManager()
          .beginTransaction()
          .replace(R.id.fragment_container, f)
          .commit();
      rootView.appbar.appBarLayout.setExpanded(true, true);
    }
  };
}

