package com.tmarat.instagramclient.di.component;

import com.tmarat.instagramclient.di.module.ActivityModule;
import com.tmarat.instagramclient.main.MainActivity;
import dagger.Component;

@Component(modules = { ActivityModule.class })
public interface AppComponent {

  void injectMainActivity(MainActivity mainActivity);
}
