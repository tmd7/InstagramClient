package com.tmarat.instagramclient.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tmarat.instagramclient.R;

public final class MainFragment extends Fragment {

  private static MainFragment fragment;

  /**
   * Empty constructor, using lazy init
   * */
  public MainFragment() {
  }

  public static MainFragment init() {

    return fragment == null ? new MainFragment() : fragment;
}

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_main, container, false);

    return view;
  }
}
