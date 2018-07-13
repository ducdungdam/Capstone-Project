package com.ducdungdam.dartfriends.utilities;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * - * Created by ducdungdam on 13.07.18.
 * -
 */

public class UnitConverterUtils {

  static public float dpToPx(Resources res, int dp) {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, res.getDisplayMetrics());
  }

  static public float StringToPx(Resources res, String str) {
    int unit = -1;
    switch (str.replaceAll("[0-9]", "")) {
      case "dp":
        unit = TypedValue.COMPLEX_UNIT_DIP;
        break;
      case "sp":
        unit = TypedValue.COMPLEX_UNIT_SP;
        break;
      case "pt":
        unit = TypedValue.COMPLEX_UNIT_PT;
        break;
      case "px":
        return Float.parseFloat(str.replaceAll("[^\\d-]", ""));
    }
    int val = Integer.parseInt(str.replaceAll("[^\\d-]", ""));
    return TypedValue.applyDimension(unit, val, res.getDisplayMetrics());
  }

}