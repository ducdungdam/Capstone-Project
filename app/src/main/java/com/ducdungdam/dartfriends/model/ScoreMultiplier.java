package com.ducdungdam.dartfriends.model;

/**
 * Created by ducdungdam on 13.07.18.
 * Model Definition of Multiplier in App.
 */

public class ScoreMultiplier {
  public final String name;
  public final String shortName;
  public final int factor;

  public ScoreMultiplier(String name, String shortName, int factor) {
    this.name = name;
    this.shortName = shortName;
    this.factor = factor;
  }

  @Override
  public String toString() {
    return String.format(
        "ScoreMultiplier: {name='%s', shortName='%s', factor='%s'}",
        name,
        shortName,
        factor
    );
  }
}
