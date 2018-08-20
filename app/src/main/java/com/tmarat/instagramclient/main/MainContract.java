package com.tmarat.instagramclient.main;

import com.tmarat.instagramclient.base.BaseMvpPresenter;
import com.tmarat.instagramclient.base.BaseView;

public interface MainContract {

  // Action callbacks. Activity/Fragment will implement
  interface View extends BaseView {

  }

  // User actions. Presenter will implement
  interface Presenter extends BaseMvpPresenter<MainContract.View> {


  }
}
