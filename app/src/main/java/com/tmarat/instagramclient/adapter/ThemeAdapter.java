package com.tmarat.instagramclient.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.common.ThemeView;
import com.tmarat.instagramclient.model.Theme;
import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.MyViewHolder> {

  private List<Theme> themeList;

  public ThemeAdapter(List<Theme> themeList) {
    this.themeList = themeList;
  }

  @NonNull @Override
  public ThemeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View itemView = LayoutInflater.from(parent.getContext())
          .inflate(R.layout.item_settings, parent, false);

    return new ThemeAdapter.MyViewHolder(itemView);
  }

  @Override public void onBindViewHolder(@NonNull ThemeAdapter.MyViewHolder holder, int position) {

    Theme theme = themeList.get(position);
    holder.themeView.setTheme(theme);

    // TODO: 28.08.2018
    /*if(ScrollingActivity.selectedTheme == position){
      holder.themeView.setActivated(true);
    }else {
      holder.themeView.setActivated(false);
    }*/
  }

  @Override public int getItemCount() {
    return themeList.size();
  }

  public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ThemeView themeView;

    public MyViewHolder(View itemView) {

      super(itemView);
      themeView = itemView.findViewById(R.id.recycler_view_settings);
      themeView.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
      // TODO: 28.08.2018 some action
    }
  }
}
