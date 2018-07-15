package com.ducdungdam.dartfriends.model;

public class GameMode {

  public final int id;
  public final String title;
  public final String shortDescription;
  public final String description;
  public final String imagePath;

  public GameMode(int id, String title, String shortDescription, String description,
      String imagePath) {
    this.id = id;
    this.title = title;
    this.shortDescription = shortDescription;
    this.description = description;
    this.imagePath= imagePath;
  }

  @Override
  public String toString() {
    return String.format(
        "GameMode: {id='%s', title='%s', shortDescription='%s', description='%s', imagePath='%s'}",
        id,
        title,
        shortDescription,
        description,
        imagePath
    );
  }

}
