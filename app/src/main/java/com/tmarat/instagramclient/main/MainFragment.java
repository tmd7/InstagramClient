package com.tmarat.instagramclient.main;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tmarat.instagramclient.R;

public final class MainFragment extends Fragment implements MainContract.View {

  private MainContract.Presenter presenter;

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
        presenter.addPhoto(getContext(), getActivity());
      }
    });

    imageView = view.findViewById(R.id.image_view_test);
  }

  @Override public void showSnackbar(int resId) {
    if (getView()!=null) {
      Snackbar snackbar = Snackbar.make(getView(), resId, Snackbar.LENGTH_SHORT);
      snackbar.dismiss();
      snackbar.show();
    }
  }

  @Override public void showImage(String currentPhotoPath) {
    if (currentPhotoPath != null) {
      imageView.setImageURI(Uri.parse(currentPhotoPath));
    } else {
      showSnackbar(R.string.error);
    }
  }
}
