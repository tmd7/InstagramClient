package com.tmarat.instagramclient.main;

import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.FileProvider;
import android.util.Log;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.base.BasePresenter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MainPresenter extends BasePresenter<MainContract.View>
    implements MainContract.Presenter {

  private static final String TAG = MainPresenter.class.getSimpleName();

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

  @Override public ArrayList<Uri> onGetPhotoFileNames(FragmentActivity activity) {
    File storageDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    ArrayList<Uri> photoNamesList = new ArrayList<>();
    Log.d(TAG, "onGetPhotoFileNames: " + storageDir);
    if (storageDir != null) {
      File[]  arrayFiles = storageDir.listFiles();
      Log.d(TAG, "onGetPhotoFileNames: " + Arrays.toString(arrayFiles));
      for (File f: arrayFiles) {
        Uri photoURI = FileProvider.getUriForFile(activity, activity.getString(R.string.authority), f);
        photoNamesList.add(photoURI);
      }
    }

    return photoNamesList;
  }
}
