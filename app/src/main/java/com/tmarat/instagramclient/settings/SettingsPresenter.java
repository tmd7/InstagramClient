package com.tmarat.instagramclient.settings;

import android.support.v4.app.FragmentActivity;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.base.BasePresenter;
import com.tmarat.instagramclient.model.Preferences;
import com.tmarat.instagramclient.util.ThemeUtil;

public class SettingsPresenter extends BasePresenter<SettingsContract.View>
    implements SettingsContract.Presenter {

  @Override public void onChangedSwitchState() {
    //some logic before
    getView().showToast(R.string.theme_changed);
  }

  @Override public void onClickItemRecyclerView(FragmentActivity activity, int position) {

    new Preferences().setPreferences(activity, ThemeUtil.getThemeId(position));
    activity.recreate();
    getView().showToast(R.string.theme_has_changed);
  }
}
