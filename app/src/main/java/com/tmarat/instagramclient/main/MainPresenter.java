package com.tmarat.instagramclient.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.FileProvider;
import android.util.Log;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.base.BasePresenter;
import com.tmarat.instagramclient.util.ConstantsUtil;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainPresenter extends BasePresenter<MainContract.View>
    implements MainContract.Presenter {

  private static final String TAG = MainPresenter.class.getSimpleName();

  private String currentPhotoPath;

  @Override
  public String getCurrentPhotoPath() {
    return currentPhotoPath;
  }

  @Override public void addPhoto(Context context,  FragmentActivity fragmentActivity) {
    // TODO: 23.08.2018 Take a photography

    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (takePictureIntent.resolveActivity(context.getPackageManager()) != null) {
      File photoFile = null;
      try {
        photoFile = createImageFile(context);
      } catch (IOException e) {
        e.printStackTrace();
        getView().showSnackbar(R.string.error);
      }

      if (photoFile !=null) {
        Uri photoUri = FileProvider.getUriForFile(
            context,
            context.getPackageName()+".fileprovider",
            photoFile);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        fragmentActivity.startActivityForResult(takePictureIntent, ConstantsUtil.REQUEST_TAKE_PHOTO);
      }
    }
  }

  private File createImageFile(Context context) throws IOException {

    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = "JPEG_" + timeStamp + "_";
    File storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    File image = File.createTempFile(
        imageFileName,
        ".jpg",
        storageDir
    );

    currentPhotoPath = image.getAbsolutePath();

    getView().showImage(currentPhotoPath);

    Log.d(TAG, "createImageFile: photo path: " + currentPhotoPath);
    return image;

  }
}
