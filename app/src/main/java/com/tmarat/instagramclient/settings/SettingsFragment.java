package com.tmarat.instagramclient.settings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import com.tmarat.instagramclient.R;

public final class SettingsFragment extends Fragment implements SettingsContract.View {

  SettingsFragment fragment;

  private SettingsContract.Presenter presenter;

  public static SettingsFragment newInstance() {
    return new SettingsFragment();
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    presenter = new SettingsPresenter();
  }

  @NonNull @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_settings, container, false);
    presenter.attach(this);
    initUI(view);

    return view;
  }

  @Override public void onDestroy() {
    super.onDestroy();
    presenter.detach();
  }

  private void initUI(View view) {

    Switch sw = view.findViewById(R.id.night_mode_sw);

    sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        presenter.onChangedSwitchState();
      }
    });
  }

  @Override public void showToast(int reId) {
    Toast t = Toast.makeText(getContext(), reId, Toast.LENGTH_SHORT);
    t.setGravity(Gravity.CENTER, 0, 0);
    t.show();
  }
}
