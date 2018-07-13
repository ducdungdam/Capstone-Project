package com.ducdungdam.dartfriends.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.ducdungdam.dartfriends.model.GameMode;
import com.ducdungdam.dartfriends.model.User;
import com.ducdungdam.dartfriends.utilities.FakeDataUtils;
import java.util.List;

public class GameViewModel extends ViewModel {

  private MutableLiveData<List<GameMode>> gameModeList;
  private MutableLiveData<List<User>> userList;

  public LiveData<List<GameMode>> getGameModeList() {
    if (gameModeList== null) {
      gameModeList = new MutableLiveData<>();
      gameModeList.setValue(FakeDataUtils.getGameModeList());
    }
    return gameModeList;
  }

  public LiveData<List<User>> getUserList() {
    if (userList == null) {
      userList = new MutableLiveData<>();
      userList.setValue(FakeDataUtils.getUserList());
    }
    return userList;
  }
}
