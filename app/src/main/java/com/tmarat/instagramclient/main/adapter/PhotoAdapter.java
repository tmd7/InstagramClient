package com.tmarat.instagramclient.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder> {

  @NonNull @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return null;
  }

  @Override public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

  }

  @Override public int getItemCount() {
    return 0;
  }

  public static class MyViewHolder extends RecyclerView.ViewHolder {

    public MyViewHolder(View itemView) {
      super(itemView);
    }
  }
}
