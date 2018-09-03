package com.tmarat.instagramclient.main.adapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tmarat.instagramclient.R;
import java.util.HashSet;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder> {

  private String[] arrayPhoto;

  public PhotoAdapter(HashSet hashSetPhoto) {
    arrayPhoto = new String[hashSetPhoto.size()];
    hashSetPhoto.toArray(arrayPhoto);
  }

  @NonNull @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View itemView =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);

    return new PhotoAdapter.MyViewHolder(itemView);
  }

  @Override public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.imageView.setImageURI(Uri.parse(arrayPhoto[position]));
  }

  @Override public int getItemCount() {
    return arrayPhoto.length;
  }

  public static class MyViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    public MyViewHolder(View itemView) {
      super(itemView);

      imageView = itemView.findViewById(R.id.item_image_container);
    }
  }
}
