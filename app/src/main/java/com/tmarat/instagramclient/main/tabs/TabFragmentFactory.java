package com.tmarat.instagramclient.main.tabs;

import android.support.v4.app.Fragment;
import com.tmarat.instagramclient.main.viewpager.photos.PhotosFragment;

public class TabFragmentFactory {

    private static final String[] TITLES = { "tab1", "tab2", "tab3"};

    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return PhotosFragment.newInstance(null);
            case 1: return PhotosFragment.newInstance(null);
            case 2: return PhotosFragment.newInstance(null);
            default: throw new IllegalArgumentException("Could not create fragment for position " + position);
        }
    }

    public int getFragmentsCount() {
        return 3;
    }

    public CharSequence getFragmentTitle(int position) {
        return TITLES[position];
    }
}
