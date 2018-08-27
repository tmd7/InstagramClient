package com.tmarat.instagramclient.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tmarat.instagramclient.R;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.app.Activity.RESULT_OK;
import static com.tmarat.instagramclient.util.ConstantsUtil.REQUEST_TAKE_PHOTO;

public final class MainFragment extends Fragment implements MainContract.View {

  private MainContract.Presenter presenter;
  private Uri photoURI;
  private ImageView imageView;

  public static MainFragment newInstance() {
    return new MainFragment();
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new MainPresenter();
  }

  @NonNull @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_main, container, false);
    presenter.attach(this);
    initUI(view);
    return view;
  }

  @Override public void onDestroy() {
    super.onDestroy();
    presenter.detach();
  }

  private void initUI(View view) {

    view.findViewById(R.id.float_bt_main_fragment)
        .setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        dispatchTakePictureIntent();
      }
    });

    imageView = view.findViewById(R.id.image_view_test);
  }

  @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
      imageView.setImageURI(photoURI);
    }
  }

  private void dispatchTakePictureIntent() {

    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    // Ensure that there's a camera activity to handle the intent
    if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {

      // Create the File where the photo should go
      File photoFile = null;
      try {
        photoFile = createImageFile();
      } catch (IOException ex) {
        showSnackbar(R.string.error);
      }

      // Continue only if the File was successfully created
      if (photoFile != null) {
        photoURI = FileProvider.getUriForFile(getActivity(),
            getActivity().getPackageName() + ".fileprovider",
            photoFile);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
      }
    }
  }

  private File createImageFile() throws IOException {
    // Create an image file name
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = "JPEG_" + timeStamp + "_";
    File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    File image = File.createTempFile(
        imageFileName,
        ".jpg",
        storageDir
    );

    // Save a file: path for use with ACTION_VIEW intents
    //mCurrentPhotoPath = image.getAbsolutePath();
    return image;
  }

  @Override public void showSnackbar(int resId) {
    if (getView()!=null) {
      Snackbar snackbar = Snackbar.make(getView(), resId, Snackbar.LENGTH_SHORT);
      snackbar.dismiss();
      snackbar.show();
    }
  }
}
