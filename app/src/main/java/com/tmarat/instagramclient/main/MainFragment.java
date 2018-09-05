package com.tmarat.instagramclient.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.main.adapter.PhotoAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static com.tmarat.instagramclient.util.ConstantsUtil.REQUEST_TAKE_PHOTO;

public final class MainFragment extends Fragment implements MainContract.View {

  private static final String TAG = MainFragment.class.getSimpleName();

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

    RecyclerView recyclerView = view.findViewById(R.id.recycler_view_main);
    recyclerView.setHasFixedSize(true);
    GridLayoutManager manager = new GridLayoutManager(getContext(), 4);
    recyclerView.setLayoutManager(manager);
    ArrayList<Uri> photoNames = presenter.onGetPhotoFileNames(getActivity());
    PhotoAdapter photoAdapter = new PhotoAdapter(photoNames);
    recyclerView.setAdapter(photoAdapter);
  }

  @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {

    }
  }

  @Override public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  private void dispatchTakePictureIntent() {
    Log.d(TAG, "dispatchTakePictureIntent: ");
    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    // Ensure that there's a camera activity to handle the intent
    if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {

      // Create the File where the photo should go
      File photoFile = null;
      try {
        photoFile = presenter.onCreateImageFile(getActivity());
      } catch (IOException ex) {
        showSnackbar(R.string.error);
      }

      // Continue only if the File was successfully created
      if (photoFile != null) {
        photoURI = FileProvider.getUriForFile(getActivity(),
             getString(R.string.authority), photoFile);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        Log.d(TAG, "dispatchTakePictureIntent: " + photoURI);
      }
    }
  }

  @Override public void showSnackbar(int resId) {
    if (getView() != null) {
      Snackbar snackbar = Snackbar.make(getView(), resId, Snackbar.LENGTH_SHORT);
      snackbar.dismiss();
      snackbar.show();
    }
  }
}
