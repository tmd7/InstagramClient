package com.tmarat.instagramclient.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class PhotoEntity {

  @PrimaryKey public long id;

  public String uriName;

  public boolean favourite;
}
