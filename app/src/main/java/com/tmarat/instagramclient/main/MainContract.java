package com.tmarat.instagramclient.main;

import android.support.v4.app.FragmentActivity;
import com.tmarat.instagramclient.base.BaseMvpPresenter;
import com.tmarat.instagramclient.base.BaseView;
import java.io.File;
import java.io.IOException;

public interface MainContract {

  // Action callbacks. Activity/Fragment will implement
  interface View extends BaseView {

    void showSnackbar(int resId);
  }

  // User actions. Presenter will implement
  interface Presenter extends BaseMvpPresenter<MainContract.View> {

    File onCreateImageFile(FragmentActivity activity) throws IOException;
  }
}
