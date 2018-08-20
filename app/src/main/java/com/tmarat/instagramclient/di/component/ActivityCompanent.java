package com.tmarat.instagramclient.di.component;

import com.tmarat.instagramclient.main.MainActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component
public interface ActivityCompanent {

  void inject(MainActivity obj);
}
