package com.tmarat.instagramclient.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.settings.SettingsFragment;
import com.tmarat.instagramclient.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setupToolbar();

    if (savedInstanceState == null) {
      ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(),
          MainFragment.newInstance(), R.id.main_container);
    }
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
        ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(),
            SettingsFragment.newInstance(), R.id.main_container, null);
        break;

      default:
        break;
    }

    return super.onOptionsItemSelected(item);
  }

  private void setupToolbar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }
}
