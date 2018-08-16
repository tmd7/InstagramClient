package com.tmarat.instagramclient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.tmarat.instagramclient.ui.MainFragment;
import com.tmarat.instagramclient.ui.SettingsFragment;

public class MainActivity extends AppCompatActivity {

  private Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initToolbar();

    startFragment(R.id.main_container, MainFragment.init());
  }

  private void startFragment(int resId, Fragment fragment) {

    getSupportFragmentManager()
        .beginTransaction()
        .replace(resId, fragment)
        .commit();
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

      case R.id.action_settings :
        startFragment(R.id.main_container, SettingsFragment.init());
        break;
    }

    return super.onOptionsItemSelected(item);
  }

  /**
   * Init toolbar
   * */
  private void initToolbar() {

    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }
}
