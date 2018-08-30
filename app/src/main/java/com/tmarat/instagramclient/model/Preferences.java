package com.tmarat.instagramclient.model;

import android.app.Activity;
import android.content.Context;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.util.ConstantsUtil;

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
}
