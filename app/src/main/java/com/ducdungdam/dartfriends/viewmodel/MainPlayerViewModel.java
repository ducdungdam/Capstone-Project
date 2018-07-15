package com.ducdungdam.dartfriends.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.ducdungdam.dartfriends.model.User;
import com.ducdungdam.dartfriends.utilities.FakeDataUtils;
import java.util.List;

public class MainPlayerViewModel extends ViewModel {

  private MutableLiveData<List<User>> userList;

  public LiveData<List<User>> getUserList() {
    if (userList == null) {
      userList = new MutableLiveData<>();
      userList.setValue(FakeDataUtils.getUserList());
    }
    return userList;
  }
}
