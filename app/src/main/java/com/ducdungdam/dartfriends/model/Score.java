package com.ducdungdam.dartfriends.model;

/**
 * Created by ducdungdam on 13.07.18.
 * Model Definition of Player in App.
 */

public class Score {
  public final String name;
  public final int value;
  private ScoreMultiplier scoreMultiplier = null;

  public Score(String name, int value) {
    this.name = name;
    this.value = value;
  }

  public String getString() {
    try {
      return scoreMultiplier.shortName + String.valueOf(value);
    } catch (Exception e) {
      return String.valueOf(value);
    }
  }

  public int getTotal() {
    try {
      return scoreMultiplier.factor * value;
    } catch (Exception e) {
      return value;
    }
  }

  public void setScoreMultiplier(ScoreMultiplier scoreMultiplier) {
    this.scoreMultiplier = scoreMultiplier;
  }

  @Override
  public String toString() {
    return String.format(
        "Score: {name='%s', value='%s'}",
        name,
        value
    );
  }
}
