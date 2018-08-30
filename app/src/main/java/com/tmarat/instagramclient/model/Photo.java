package com.tmarat.instagramclient.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Photo implements Parcelable {

  private Uri uri;
  private boolean favourite;

  public Photo(Uri uri, boolean favourite) {
    this.uri = uri;
    this.favourite = favourite;
  }

  public Photo(Parcel in) {
    uri = in.readParcelable(Uri.class.getClassLoader());
    favourite = in.readByte() != 0;
  }

  public static final Creator<Photo> CREATOR = new Creator<Photo>() {
    @Override
    public Photo createFromParcel(Parcel in) {
      return new Photo(in);
    }

    @Override
    public Photo[] newArray(int size) {
      return new Photo[size];
    }
  };

  public Uri getUri() {
    return uri;
  }

  public boolean isFavourite() {
    return favourite;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(uri, flags);
    dest.writeByte((byte) (favourite ? 1 : 0));
  }
}
