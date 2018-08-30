package com.tmarat.instagramclient.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.tmarat.instagramclient.model.Preferences;
import com.tmarat.instagramclient.util.ConstantsUtil;

public abstract class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    int themeResId = new Preferences().getPreferences(this, ConstantsUtil.THEME_KEY);
    setTheme(themeResId);
  }
}
