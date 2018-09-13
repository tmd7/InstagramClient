package com.tmarat.instagramclient.main;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.main.adapter.PhotoAdapter;
import java.io.File;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static com.tmarat.instagramclient.util.ConstantsUtil.REQUEST_TAKE_PHOTO;

public final class MainFragment extends Fragment implements MainContract.View {

  private static final String TAG = MainFragment.class.getSimpleName();
  private static final String KEY = "getArgs";
  private static final int SPAN_COUNT_PORTRAIT = 2;
  private static final int SPAN_COUNT_LAND = 3;

  private MainContract.Presenter presenter;
  private RecyclerView recyclerView;

  private int getOrientation() {
    return getResources().getConfiguration().orientation;
  }

  public static MainFragment newInstance(Bundle bundle) {
    MainFragment currentFragment = new MainFragment();
    Bundle args = new Bundle();
    args.putBundle(KEY, bundle);
    currentFragment.setArguments(args);

    return currentFragment;
  }

  private File getStorageDir() {
    return getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
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

    initFloatBt(view);

    initRecyclerView(view);

    presenter.onCreatedView(getStorageDir());

    return view;
  }

  private void initRecyclerView(View view) {
    recyclerView = view.findViewById(R.id.recycler_view_main_fragment);
    recyclerView.setHasFixedSize(true);

    GridLayoutManager manager;

    if (getOrientation() == Configuration.ORIENTATION_PORTRAIT) {

      manager = new GridLayoutManager(getContext(), SPAN_COUNT_PORTRAIT);
      recyclerView.setLayoutManager(manager);
    } else {

      manager = new GridLayoutManager(getContext(), SPAN_COUNT_LAND);
      recyclerView.setLayoutManager(manager);
    }
  }

  @Override public void onDestroy() {
    super.onDestroy();
    presenter.detach();
  }

  private void initFloatBt(View view) {

    view.findViewById(R.id.float_bt_main_fragment)
        .setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {

            presenter.onFabClicked(getStorageDir());
          }
        });
  }

  @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {

    }
  }

  @Override public void dispatchTakePictureIntent(File image) {

    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    // Ensure that there's a camera activity to handle the intent
    if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null
        && image != null) {

      Uri photoURI = FileProvider.getUriForFile(getActivity(),
          getString(R.string.authority), image);
      takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
      startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
    }
  }

  @Override public void onSetAdapterRecyclerView(File[] arrayFiles) {

    ArrayList<Uri> uriPhotoList = new ArrayList<>();

    if (getActivity() != null) {
      for (File f : arrayFiles) {
        Uri photoURI =
            FileProvider.getUriForFile(getActivity(), getActivity().getString(R.string.authority),
                f);
        uriPhotoList.add(photoURI);
      }
    }

    PhotoAdapter photoAdapter = new PhotoAdapter(uriPhotoList);
    recyclerView.setAdapter(photoAdapter);
  }

  @Override public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  @Override public void showSnackbar(int resId) {
    if (getView() != null) {
      Snackbar snackbar = Snackbar.make(getView(), resId, Snackbar.LENGTH_SHORT);
      snackbar.dismiss();
      snackbar.show();
    }
  }
}
