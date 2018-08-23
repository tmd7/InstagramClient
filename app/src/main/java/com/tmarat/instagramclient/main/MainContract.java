package com.tmarat.instagramclient.main;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tmarat.instagramclient.base.BaseMvpPresenter;
import com.tmarat.instagramclient.base.BaseView;

public interface MainContract {

  // Action callbacks. Activity/Fragment will implement
  interface View extends BaseView {

    void showSnackbar(int resId);

    void showImage(String currentPhotoPath);
  }

  // User actions. Presenter will implement
  interface Presenter extends BaseMvpPresenter<MainContract.View> {

    void addPhoto(Context context,  FragmentActivity activity);

    String getCurrentPhotoPath();
  }
}
