package com.tmarat.instagramclient.util;

import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.model.Theme;
import java.util.ArrayList;

public class ThemeUtil {

  public static ArrayList<Theme> getThemeList(){
    ArrayList<Theme> themeArrayList = new ArrayList<>();
    themeArrayList.add(new Theme(0,R.color.primaryColorRed, R.color.primaryDarkColorRed, R.color.secondaryColorRed));
    themeArrayList.add(new Theme(1,R.color.primaryColorPink, R.color.primaryDarkColorPink, R.color.secondaryColorPink));
    themeArrayList.add(new Theme(2,R.color.primaryColorPurple, R.color.primaryDarkColorPurple, R.color.secondaryColorPurple));
    themeArrayList.add(new Theme(3,R.color.primaryColorDeepPurple, R.color.primaryDarkColorDeepPurple, R.color.secondaryColorDeepPurple));
    themeArrayList.add(new Theme(4,R.color.primaryColorIndigo, R.color.primaryDarkColorIndigo, R.color.secondaryColorIndigo));
    themeArrayList.add(new Theme(5,R.color.primaryColorBlue, R.color.primaryDarkColorBlue, R.color.secondaryColorBlue));
    themeArrayList.add(new Theme(6,R.color.primaryColorLightBlue, R.color.primaryDarkColorLightBlue, R.color.secondaryColorLightBlue));
    themeArrayList.add(new Theme(7,R.color.primaryColorCyan, R.color.primaryDarkColorCyan, R.color.secondaryColorCyan));
    themeArrayList.add(new Theme(8,R.color.primaryColorTeal, R.color.primaryDarkColorTeal, R.color.secondaryColorTeal));
    themeArrayList.add(new Theme(9,R.color.primaryColorGreen, R.color.primaryDarkColorGreen, R.color.secondaryColorGreen));
    themeArrayList.add(new Theme(10,R.color.primaryColorLightGreen, R.color.primaryDarkColorLightGreen, R.color.secondaryColorLightGreen));
    themeArrayList.add(new Theme(11,R.color.primaryColorLime, R.color.primaryDarkColorLime, R.color.secondaryColorLime));
    themeArrayList.add(new Theme(12,R.color.primaryColorYellow, R.color.primaryDarkColorYellow, R.color.secondaryColorYellow));
    themeArrayList.add(new Theme(13,R.color.primaryColorAmber, R.color.primaryDarkColorAmber, R.color.secondaryColorAmber));
    themeArrayList.add(new Theme(14,R.color.primaryColorOrange, R.color.primaryDarkColorOrange, R.color.secondaryColorOrange));
    themeArrayList.add(new Theme(15,R.color.primaryColorDeepOrange, R.color.primaryDarkColorDeepOrange, R.color.secondaryColorDeepOrange));
    themeArrayList.add(new Theme(16,R.color.primaryColorBrown, R.color.primaryDarkColorBrown, R.color.secondaryColorBrown));
    themeArrayList.add(new Theme(17,R.color.primaryColorGray, R.color.primaryDarkColorGray, R.color.secondaryColorGray));
    themeArrayList.add(new Theme(18,R.color.primaryColorBlueGray, R.color.primaryDarkColorBlueGray, R.color.secondaryColorBlueGray));
    return themeArrayList;
  }
}
