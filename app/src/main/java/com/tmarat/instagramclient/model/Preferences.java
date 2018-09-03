package com.tmarat.instagramclient.model;

import android.app.Activity;
import android.content.Context;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.util.ConstantsUtil;
import java.util.HashSet;
import java.util.Set;

public class Preferences {

  public void setPreferences(Activity activity, int resId) {

    activity.getPreferences(Context.MODE_PRIVATE)
        .edit()
        .putInt(ConstantsUtil.THEME_KEY, resId)
        .apply();
  }

  public int getPreferences(Activity activity, String key) {

    return activity.getPreferences(Context.MODE_PRIVATE).getInt(key, R.style.AppTheme_NoActionBar);
  }

  public void setPreferencesSetString(Activity activity, Set<String > stringSet) {
    activity.getPreferences(Context.MODE_PRIVATE)
        .edit()
        .putStringSet(ConstantsUtil.SET_PHOTOS_KEY, stringSet)
        .apply();
  }

  public Set<String > getPreferencesSetString(Activity activity, String key) {
    return activity.getPreferences(Context.MODE_PRIVATE).getStringSet(key, new HashSet<String>());
  }
}
