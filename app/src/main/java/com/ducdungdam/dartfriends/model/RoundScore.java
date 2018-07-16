package com.ducdungdam.dartfriends.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducdungdam on 13.07.18.
 * Model Definition of Player in App.
 */

public class RoundScore {

  private List<Score> scores = new ArrayList<>();

  public RoundScore() {
  }

  public int getTotalRoundScore() {
    int total = 0;
    for (Score score : scores) {
      total = total + score.getTotal();
    }
    return total;
  }

  public List<Score> getScores() {
    return scores;
  }

  public void setScore(int index, Score score) {
    try {
      scores.set(index, score);
    } catch (IndexOutOfBoundsException e) {
      scores.add(index, score);
    }

  }


  @Override
  public String toString() {
    try {
      return String.format(
          "Round score: {%s}",
          scores
      );
    } catch (Exception e) {
      return "N/A";
    }
  }
}
