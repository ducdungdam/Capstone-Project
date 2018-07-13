package com.ducdungdam.dartfriends.widget.NavigationView;

/**
 * Created by ducdungdam on 13.07.18.
 */

public class NavigationViewItem {

  public enum Type {
    MAIN,
    SUB,
    OTHER
  }

  public final String title;
  public final Type type;

  public NavigationViewItem(String title, Type type) {
    this.title = title;
    this.type = type;
  }

  public static class MainNavigationViewItem extends NavigationViewItem {

    public final int iconResId;

    public MainNavigationViewItem(String title, int iconResId) {
      super(title, Type.MAIN);
      this.iconResId = iconResId;
    }
  }

  public static class SubNavigationViewItem extends NavigationViewItem {

    public final int iconResId;

    public SubNavigationViewItem(String title, int iconResId) {
      super(title, Type.SUB);
      this.iconResId = iconResId;
    }
  }

  public static class OtherNavigationViewItem extends NavigationViewItem {

    public OtherNavigationViewItem(String title) {
      super(title, Type.OTHER);
    }
  }

}
