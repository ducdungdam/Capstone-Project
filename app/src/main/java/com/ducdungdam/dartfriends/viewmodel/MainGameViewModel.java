package com.ducdungdam.dartfriends.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.ducdungdam.dartfriends.model.GameMode;
import com.ducdungdam.dartfriends.model.Player;
import com.ducdungdam.dartfriends.utilities.FakeDataUtils;
import java.util.List;

public class MainGameViewModel extends ViewModel {

  private MutableLiveData<List<GameMode>> gameModeList;
  private MutableLiveData<List<Player>> playerList;

  public LiveData<List<GameMode>> getGameModeList() {
    if (gameModeList== null) {
      gameModeList = new MutableLiveData<>();
      gameModeList.setValue(FakeDataUtils.getGameModeList());
    }
    return gameModeList;
  }

  public LiveData<List<Player>> getPlayerList() {
    if (playerList == null) {
      playerList = new MutableLiveData<>();
      playerList.setValue(FakeDataUtils.getPlayerList());
    }
    return playerList;
  }
}
