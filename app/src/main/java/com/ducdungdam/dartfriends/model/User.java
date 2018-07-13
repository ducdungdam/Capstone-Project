package com.ducdungdam.dartfriends.model;

/**
 * Created by ducdungdam on 13.07.18.
 * Model Definition of User in App.
 */

public class User {

  public final int id;
  public final String userName;
  public final String imageSrc;

  public User(int id, String userName, String imageSrc) {
    this.id = id;
    this.userName = userName;
    this.imageSrc = imageSrc;
  }

  @Override
  public String toString() {
    return String.format(
        "User: {userName='%s', imageSrc='%s'}",
        userName,
        imageSrc
    );
  }
}
