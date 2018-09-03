package com.tmarat.instagramclient.main;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import com.tmarat.instagramclient.base.BasePresenter;
import com.tmarat.instagramclient.model.Preferences;
import com.tmarat.instagramclient.util.ConstantsUtil;
import java.util.HashSet;
import java.util.Set;

public class MainPresenter extends BasePresenter<MainContract.View>
    implements MainContract.Presenter {

  private static final String TAG = MainPresenter.class.getSimpleName();

  @Override public void requestCodeIsOk(Preferences preferences, Uri photoURI,
      FragmentActivity activity) {

    Set<String> stringSet = preferences.
        getPreferencesSetString(activity, ConstantsUtil.SET_PHOTOS_KEY);

    stringSet.add(photoURI.toString());
    preferences.setPreferencesSetString(activity, stringSet);
  }

  @Override public HashSet<String> getPreferences(FragmentActivity activity,
      Preferences preferences) {
    return (HashSet<String>) preferences.getPreferencesSetString(activity, ConstantsUtil.SET_PHOTOS_KEY);
  }
}
