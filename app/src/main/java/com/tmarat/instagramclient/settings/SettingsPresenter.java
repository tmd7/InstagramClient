package com.tmarat.instagramclient.settings;

import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.base.BasePresenter;

public class SettingsPresenter extends BasePresenter<SettingsContract.View>
    implements SettingsContract.Presenter {

  @Override public void onChangedSwitchState() {
    //some logic before
    getView().showToast(R.string.theme_changed);
  }
}
