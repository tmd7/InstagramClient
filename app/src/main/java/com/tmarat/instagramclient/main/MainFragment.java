package com.tmarat.instagramclient.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tmarat.instagramclient.R;

public final class MainFragment extends Fragment implements MainContract.View {

  MainContract.Presenter presenter;

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
        presenter.addPhoto();
      }
    });
  }

  @Override public void showSnackbar() {
    if (getView()!=null) {
      Snackbar snackbar = Snackbar.make(getView(), R.string.photo_has_added, Snackbar.LENGTH_SHORT);
      snackbar.dismiss();
      snackbar.show();
    }
  }
}
