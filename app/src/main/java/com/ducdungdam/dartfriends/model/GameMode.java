package com.ducdungdam.dartfriends.model;

public class GameMode {
  public final String title;
  public final String description;

  public GameMode(String title, String description) {
    this.title = title;
    this.description = description;
  }

  @Override
  public String toString() {
    return String.format(
        "GameMode: {title='%s', description='%s'}",
        title,
        description
    );
  }

}
