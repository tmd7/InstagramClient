package com.tmarat.instagramclient.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface PhotoDao {

  @Query("SELECT * FROM photoentity") List<PhotoEntity> getAll();

  @Insert void insert(PhotoEntity photoEntity);
}
