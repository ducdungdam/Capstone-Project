package com.ducdungdam.dartfriends.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.ducdungdam.dartfriends.R;
import com.ducdungdam.dartfriends.model.User;
import com.ducdungdam.dartfriends.utilities.FakeDataUtils;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewItem;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewItem.MainNavigationViewItem;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewItem.OtherNavigationViewItem;
import com.ducdungdam.dartfriends.widget.NavigationView.NavigationViewItem.SubNavigationViewItem;
import java.util.ArrayList;


public class MainViewModel extends ViewModel {

  private MutableLiveData<User> user;

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

  public LiveData<User> getUser() {
    if (user == null) {
      user = new MutableLiveData<>();
      user.setValue(FakeDataUtils.getUser());
    }
    return user;
  }
}
