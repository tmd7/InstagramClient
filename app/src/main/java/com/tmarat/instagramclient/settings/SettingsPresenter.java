package com.tmarat.instagramclient.settings;

import com.tmarat.instagramclient.base.BasePresenter;
import com.tmarat.instagramclient.util.ConstantsUtil;

public class SettingsPresenter extends BasePresenter<SettingsContract.View>
    implements SettingsContract.Presenter {

  @Override public void onChangedSwitchState() {
    //some logic before
    getView().showToast(ConstantsUtil.THEME_HAS_CHANGED);
  }

  @Override public void onClickItemRecyclerView(int position) {

    getView().onChangeAppTheme(position);
    getView().recreateActivity();
    getView().showToast(ConstantsUtil.THEME_HAS_CHANGED);
  }
}
