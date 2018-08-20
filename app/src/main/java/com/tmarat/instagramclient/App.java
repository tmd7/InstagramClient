package com.tmarat.instagramclient;

import android.app.Application;
import com.tmarat.instagramclient.di.component.AppComponent;

public class App extends Application {

  private static AppComponent component;

  public static AppComponent getComponent() {
    return component;
  }

  @Override public void onCreate() {
    super.onCreate();

    component = DaggerAppComponent.create();
  }
}
