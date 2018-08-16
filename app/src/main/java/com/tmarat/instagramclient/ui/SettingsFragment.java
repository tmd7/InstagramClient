package com.tmarat.instagramclient.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tmarat.instagramclient.R;

public final class SettingsFragment extends Fragment {

  @NonNull @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_settings, container, false);

    initUI(view);

    return view;
  }

  private void initUI(View view) {
  }
}
