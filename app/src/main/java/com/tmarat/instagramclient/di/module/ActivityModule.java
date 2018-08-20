package com.tmarat.instagramclient.di.module;

import android.content.Context;
import com.tmarat.instagramclient.main.MainContract;
import com.tmarat.instagramclient.main.MainPresenter;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ActivityModule {

  private Context context;

  public ActivityModule(Context context) {
    this.context = context;
  }

  @Provides
  @Singleton MainContract.Presenter providesMainPresenter() {
    return new MainPresenter();
  }
}
