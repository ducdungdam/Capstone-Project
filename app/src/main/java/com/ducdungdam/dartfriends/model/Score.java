package com.ducdungdam.dartfriends.model;

/**
 * Created by ducdungdam on 13.07.18.
 * Model Definition of User in App.
 */

public class Score {
  public static final int TYPE_SCORE = 0;
  public static final int TYPE_MULTIPLIER = 1;

  public final String name;
  public final int value;
  public final int type;

  public Score(String name, int value, int type) {
    this.name = name;
    this.value = value;
    this.type = type;
  }

  @Override
  public String toString() {
    return String.format(
        "Score: {name='%s', value='%s', type='%s'}",
        name,
        value,
        type
    );
  }
}
