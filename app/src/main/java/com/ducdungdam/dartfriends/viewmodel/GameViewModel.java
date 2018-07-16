package com.ducdungdam.dartfriends.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.ducdungdam.dartfriends.model.Player;
import com.ducdungdam.dartfriends.model.RoundScore;
import com.ducdungdam.dartfriends.model.Score;
import java.util.List;


public class GameViewModel extends ViewModel {

  private MutableLiveData<List<Player>> playerList;
  private MutableLiveData<Integer> currentPlayerIndex;
  private MutableLiveData<Integer> currentThrowIndex;

  private MutableLiveData<RoundScore[]> scoreList;
  private MutableLiveData<RoundScore> currentRoundScore;


  public int getCurrentPlayerPoint() {

    if (currentPlayerIndex == null || scoreList == null) {
      return 512;
    }
    int totalPoints = 0;
    for (int i = currentPlayerIndex.getValue(); i < scoreList.getValue().length;
        i += playerList.getValue().size()) {
      totalPoints = totalPoints + scoreList.getValue()[i].getTotalRoundScore();
    }
    return 512 - totalPoints;
  }

  public void setPlayerList(List<Player> playerList) {
    if (this.playerList == null) {
      this.playerList = new MutableLiveData<>();
    }
    this.playerList.setValue(playerList);
  }

  public Player getPlayer() {
    if (playerList == null) {
      return null;
    }
    if (currentPlayerIndex == null) {
      currentPlayerIndex = new MutableLiveData<>();
      currentPlayerIndex.setValue(0);
    }
    return playerList.getValue().get(currentPlayerIndex.getValue());
  }

  public LiveData<Integer> getCurrentPlayerIndex() {
    if (currentPlayerIndex == null) {
      currentPlayerIndex = new MutableLiveData<>();
      currentPlayerIndex.setValue(0);
    }
    return currentPlayerIndex;
  }

  public void nextPlayer() {
    int index = (getCurrentPlayerIndex().getValue() + 1) % playerList.getValue().size();
    currentPlayerIndex.setValue(index);
  }

  public LiveData<Integer> getCurrentThrowIndex() {
    if (currentThrowIndex == null) {
      currentThrowIndex = new MutableLiveData<>();
      currentThrowIndex.setValue(0);
    }
    return currentThrowIndex;
  }

  public void setCurrentThrowIndex(int index) {
    currentThrowIndex.setValue(index);
  }

  public LiveData<RoundScore> getCurrentRoundScore() {
    if (currentRoundScore == null) {
      currentRoundScore = new MutableLiveData<>();
      currentRoundScore.setValue(new RoundScore());
    }
    return currentRoundScore;
  }

  public void setCurrentRoundScore(Score score) {
    RoundScore roundScore = currentRoundScore.getValue();
    roundScore.setScore(currentThrowIndex.getValue(), score);
    currentRoundScore.setValue(roundScore);
  }
}
