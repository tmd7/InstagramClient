package com.tmarat.instagramclient.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {PhotoEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

  public abstract PhotoDao photoDao();
}
