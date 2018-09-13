package com.tmarat.instagramclient.main;

import com.tmarat.instagramclient.base.BaseMvpPresenter;
import com.tmarat.instagramclient.base.BaseView;
import java.io.File;

public interface MainContract {

  // Action callbacks. Activity/Fragment will implement
  interface View extends BaseView {

    void showSnackbar(int resId);

    void dispatchTakePictureIntent(File image);

    void onSetAdapterRecyclerView(File[] arrayFiles);
  }

  // User actions. Presenter will implement
  interface Presenter extends BaseMvpPresenter<MainContract.View> {

    void onFabClicked(File storageDir);

    void onCreatedView(File storageDir);
  }
}
