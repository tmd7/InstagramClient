package com.tmarat.instagramclient.base;

public class BasePresenter<V extends BaseView> implements BaseMvpPresenter<V> {

  /**
   * Attached view
   */
  private V view;

  public V getView() {
    return this.view;
  }

  @Override public void attach(V view) {
    this.view = view;
  }

  @Override public void detach() {
    this.view = null;
  }

  @Override public boolean isAttached() {
    return this.view != null;
  }
}
