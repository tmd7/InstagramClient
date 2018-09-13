package com.tmarat.instagramclient.main;

import com.tmarat.instagramclient.base.BasePresenter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainPresenter extends BasePresenter<MainContract.View>
    implements MainContract.Presenter {

  @Override public void onCreatedView(File storageDir) {

    if (storageDir != null) {

      File[] arrayFiles = storageDir.listFiles();

      getView().onSetAdapterRecyclerView(arrayFiles);
    }
  }

  @Override public void onFabClicked(File storageDir) {
    // Create the File where the photo should go
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = "JPEG_" + timeStamp + "_";

    File image = null;

    try {
      image = File.createTempFile(imageFileName, ".jpg", storageDir);
    } catch (IOException e) {
      e.printStackTrace();
    }

    getView().dispatchTakePictureIntent(image);
  }
}