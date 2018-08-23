package com.tmarat.instagramclient.main;

import com.tmarat.instagramclient.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainContract.View>
    implements MainContract.Presenter {

  @Override public void addPhoto() {
    // TODO: 23.08.2018 Take a photography
    getView().showSnackbar();
  }
}
