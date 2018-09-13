package com.tmarat.instagramclient.settings;

import android.support.v4.app.FragmentActivity;
import com.tmarat.instagramclient.base.BaseMvpPresenter;
import com.tmarat.instagramclient.base.BaseView;

public interface SettingsContract {

  // Action callbacks. Activity/Fragment will implement
  interface View extends BaseView {

    void recreateActivity();

    void showToast(int resId);

    void onChangeAppTheme(int position);
  }

  // User actions. Presenter will implement
  interface Presenter extends BaseMvpPresenter<SettingsContract.View> {

    void onChangedSwitchState();

    void onClickItemRecyclerView(int position);
  }
}
