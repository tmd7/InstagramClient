package com.tmarat.instagramclient.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import javax.inject.Inject;

public abstract class BaseActivity<T extends BaseMvpPresenter> extends AppCompatActivity
    implements BaseView {

  /**
   * Injected presenter
   */
  @Inject
  T presenter;

  public T getPresenter() {
    return presenter;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getContentResource());

    init(savedInstanceState);
  }

  /**
   * Layout resource to be inflated
   *
   * @return layout resource
   */
  protected abstract int getContentResource();

  /**
   * Initialisations
   */
  protected abstract void init(@Nullable Bundle state);

  /**
   * Injecting dependencies
   */
  protected abstract void injectDependencies();
}
