package com.tmarat.instagramclient.main;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import com.tmarat.instagramclient.base.BaseMvpPresenter;
import com.tmarat.instagramclient.base.BaseView;
import com.tmarat.instagramclient.model.Preferences;
import java.util.HashSet;

public interface MainContract {

  // Action callbacks. Activity/Fragment will implement
  interface View extends BaseView {

    void showSnackbar(int resId);
  }

  // User actions. Presenter will implement
  interface Presenter extends BaseMvpPresenter<MainContract.View> {

    void requestCodeIsOk(Preferences preferences, Uri photoURI,
        FragmentActivity activity);

    HashSet<String> getPreferences(FragmentActivity activity,
        Preferences preferences);
  }
}
