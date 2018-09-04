package com.tmarat.instagramclient.main;

import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import com.tmarat.instagramclient.base.BasePresenter;
import com.tmarat.instagramclient.model.Preferences;
import com.tmarat.instagramclient.util.ConstantsUtil;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

  @Override public File onCreateImageFile(FragmentActivity activity) throws IOException {
    // Create an image file name
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = "JPEG_" + timeStamp + "_";
    File storageDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    File image = File.createTempFile(
        imageFileName,
        ".jpg",
        storageDir
    );

    return image;
  }
}
