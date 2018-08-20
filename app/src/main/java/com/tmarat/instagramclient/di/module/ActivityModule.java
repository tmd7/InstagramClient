package com.tmarat.instagramclient.di.module;

import com.tmarat.instagramclient.main.MainPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

  @Provides MainPresenter provideMainPresenter() {
    return new MainPresenter();
  }
}
