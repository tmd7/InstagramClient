package com.tmarat.instagramclient.main.viewpager.photos.adapter;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import com.tmarat.instagramclient.base.BaseMvpPresenter;
import com.tmarat.instagramclient.base.BaseView;
import com.tmarat.instagramclient.main.MainContract;
import java.util.ArrayList;

public class PhotosContract {

  // Action callbacks. Activity/Fragment will implement
  public interface View extends BaseView {

  }

  // User actions. Presenter will implement
  public interface Presenter extends BaseMvpPresenter<MainContract.View> {

    ArrayList<Uri> onGetPhotoFileNames(FragmentActivity activity);
  }
}
