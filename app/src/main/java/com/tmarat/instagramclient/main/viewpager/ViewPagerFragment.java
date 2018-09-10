package com.tmarat.instagramclient.main.viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.main.tabs.CustomFragmentPagerAdapter;
import com.tmarat.instagramclient.main.tabs.TabFragmentFactory;

public class ViewPagerFragment extends Fragment {

  private static final String KEY = "getArgs";

  public static ViewPagerFragment newInstance(Bundle bundle) {
    ViewPagerFragment currentFragment = new ViewPagerFragment();
    Bundle args = new Bundle();
    args.putBundle(KEY, bundle);
    currentFragment.setArguments(args);

    return currentFragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

    setViewPager(view);

    return view;
  }

  private void setViewPager(View view) {
    TabFragmentFactory tabFragmentFactory = new TabFragmentFactory();

    CustomFragmentPagerAdapter adapter =
        new CustomFragmentPagerAdapter(getChildFragmentManager(), tabFragmentFactory);

    ViewPager viewPager = view.findViewById(R.id.view_pager);
    viewPager.setAdapter(adapter);

    if (getActivity() != null) {

      TabLayout tabLayout = getActivity().findViewById(R.id.tabs);
      tabLayout.setupWithViewPager(viewPager);

      viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
      tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    } else {

      throw new NullPointerException("getActivity() = null");
    }
  }
}
