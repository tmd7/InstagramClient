package com.tmarat.instagramclient.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * This provides methods to help Activities load their UI.
 */
public class ActivityUtils {

  public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
      @NonNull Fragment fragment, int frameId) {

    checkNotNull(fragmentManager);
    checkNotNull(fragment);

    fragmentManager
        .beginTransaction()
        .replace(frameId, fragment)
        .commit();
  }

  /* Note: add fragment to back stack */
  public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
      @NonNull Fragment fragment, int frameId, @Nullable String name) {

    checkNotNull(fragmentManager);
    checkNotNull(fragment);

    fragmentManager
        .beginTransaction()
        .replace(frameId, fragment)
        .addToBackStack(name)
        .commit();
  }
}
