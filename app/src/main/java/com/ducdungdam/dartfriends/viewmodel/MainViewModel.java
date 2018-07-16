package com.ducdungdam.dartfriends.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.model.Player;
import com.ducdungdam.dartfriends.utilities.FakeDataUtils;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewItem;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewItem.MainNavigationViewItem;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewItem.OtherNavigationViewItem;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewItem.SubNavigationViewItem;
import java.util.ArrayList;


public class MainViewModel extends ViewModel {

  private MutableLiveData<Player> player;

  public ArrayList<NavigationViewItem> getNavigationViewItemList() {
    ArrayList<NavigationViewItem> navigationItems = new ArrayList<>();

    // Populating list items
    navigationItems
        .add(new MainNavigationViewItem("Start Game", R.drawable.ic_launcher_foreground));
    navigationItems.add(new MainNavigationViewItem("Players", R.drawable.ic_launcher_foreground));
    navigationItems.add(new MainNavigationViewItem("History", R.drawable.ic_launcher_foreground));
    navigationItems.add(new MainNavigationViewItem("Achievements", R.drawable.ic_launcher_foreground));

    navigationItems.add(new SubNavigationViewItem("Settings", R.drawable.ic_launcher_foreground));

    navigationItems.add(new OtherNavigationViewItem("Privacy and Security"));
    navigationItems.add(new OtherNavigationViewItem("Help Center"));
    navigationItems.add(new OtherNavigationViewItem("Imprint"));

    return navigationItems;
  }

  public LiveData<Player> getPlayer() {
    if (player == null) {
      player = new MutableLiveData<>();
      player.setValue(FakeDataUtils.getPlayer());
    }
    return player;
  }
}
