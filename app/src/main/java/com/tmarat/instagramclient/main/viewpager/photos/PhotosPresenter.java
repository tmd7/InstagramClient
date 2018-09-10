package com.tmarat.instagramclient.main.viewpager.photos;

import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.FileProvider;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.base.BasePresenter;
import com.tmarat.instagramclient.main.MainContract;
import com.tmarat.instagramclient.main.viewpager.photos.adapter.PhotosContract;
import java.io.File;
import java.util.ArrayList;

public class PhotosPresenter extends BasePresenter<MainContract.View>
    implements PhotosContract.Presenter {


  @Override public ArrayList<Uri> onGetPhotoFileNames(FragmentActivity activity) {

    File storageDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    ArrayList<Uri> photoNamesList = new ArrayList<>();

    if (storageDir != null) {
      File[]  arrayFiles = storageDir.listFiles();

      for (File f: arrayFiles) {
        Uri photoURI = FileProvider.getUriForFile(activity, activity.getString(R.string.authority), f);
        photoNamesList.add(photoURI);
      }
    }
    return photoNamesList;
  }
}
