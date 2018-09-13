package com.tmarat.instagramclient.main.adapter;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.tmarat.instagramclient.R;
import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder> {

  private ArrayList<Uri> photoNames;

  public PhotoAdapter(ArrayList<Uri> photoNames) {
    this.photoNames = photoNames;
  }

  @NonNull @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View itemView =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);

    return new PhotoAdapter.MyViewHolder(itemView);
  }

  @Override public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Picasso.get()
        .load(photoNames.get(position))
        .resize(600, 600)
        .centerInside()
        .into(holder.imageView);
  }

  @Override public int getItemCount() {
    return photoNames.size();
  }

  public static class MyViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    public MyViewHolder(View itemView) {
      super(itemView);

      imageView = itemView.findViewById(R.id.item_image_container);
    }
  }
}