package com.tmarat.instagramclient;

import android.app.Application;
import android.arch.persistence.room.Room;
import com.tmarat.instagramclient.data.AppDatabase;

public class App extends Application {

  private static final String DATABASE_NAME = "database";
  private static App instance;

  private AppDatabase database;

  @Override public void onCreate() {
    super.onCreate();

    instance = this;
    database = Room.databaseBuilder(this, AppDatabase.class, DATABASE_NAME).build();
  }

  public static App getInstance() {
    return instance;
  }

  public AppDatabase getDatabase() {
    return database;
  }
}
