package com.tmarat.instagramclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.tmarat.instagramclient.ui.MainFragment;
import com.tmarat.instagramclient.ui.SettingsFragment;
import com.tmarat.instagramclient.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initToolbar();

    ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
        new MainFragment(), R.id.main_container);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    switch (item.getItemId()) {

      case R.id.action_settings:
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
            new SettingsFragment(), R.id.main_container, null);
        break;

      default:
        break;
    }

    return super.onOptionsItemSelected(item);
  }

  private void initToolbar() {

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }
}
