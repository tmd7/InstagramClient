package com.tmarat.instagramclient.main;

import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import com.tmarat.instagramclient.base.BasePresenter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainPresenter extends BasePresenter<MainContract.View>
    implements MainContract.Presenter {

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
