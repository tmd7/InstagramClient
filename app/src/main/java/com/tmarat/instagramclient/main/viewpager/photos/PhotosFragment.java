package com.tmarat.instagramclient.main.viewpager.photos;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.main.viewpager.photos.adapter.PhotoAdapter;
import java.util.ArrayList;

public class PhotosFragment extends Fragment {

  private static final String KEY = "getArgs";

  private PhotosPresenter presenter;

  public static PhotosFragment newInstance(Bundle bundle) {
    PhotosFragment currentFragment = new PhotosFragment();
    Bundle args = new Bundle();
    args.putBundle(KEY, bundle);
    currentFragment.setArguments(args);

    return currentFragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    presenter = new PhotosPresenter();
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_photos, container, false);

    setRecyclerView(view);

    return view;
  }

  private void setRecyclerView(View view) {
    RecyclerView recyclerView = view.findViewById(R.id.recycler_view_photos);
    recyclerView.setHasFixedSize(true);
    GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
    recyclerView.setLayoutManager(manager);


    ArrayList<Uri> photoNames = presenter.onGetPhotoFileNames(getActivity());
    PhotoAdapter photoAdapter = new PhotoAdapter(photoNames);
    recyclerView.setAdapter(photoAdapter);
  }
}
