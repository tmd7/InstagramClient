package com.tmarat.instagramclient.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.base.BaseActivity;
import com.tmarat.instagramclient.ui.MainFragment;
import com.tmarat.instagramclient.ui.SettingsFragment;
import com.tmarat.instagramclient.util.ActivityUtils;

public class MainActivity extends BaseActivity implements MainContract.View {

  @Override protected void init(@Nullable Bundle state) {

    setUpToolbar();

    ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
        MainFragment.newInstance(), R.id.main_container);
  }

  @Override protected int getContentResource() {
    return R.layout.activity_main;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override protected void onDestroy() {
    super.onDestroy();

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {

      case R.id.action_settings:
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
            SettingsFragment.newInstance(), R.id.main_container, null);
        break;

      default:
        break;
    }

    return super.onOptionsItemSelected(item);
  }

  private void setUpToolbar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }
}
