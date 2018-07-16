package com.ducdungdam.dartfriends.model;

/**
 * Created by ducdungdam on 13.07.18.
 * Model Definition of Player in App.
 */

public class Player {

  public final int id;
  public final String name;
  public final String imageSrc;

  public Player(int id, String name, String imageSrc) {
    this.id = id;
    this.name = name;
    this.imageSrc = imageSrc;
  }

  @Override
  public String toString() {
    return String.format(
        "Player: {name='%s', imageSrc='%s'}",
        name,
        imageSrc
    );
  }
}
