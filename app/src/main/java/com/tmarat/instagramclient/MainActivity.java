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

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initToolbar();

    startFragment(R.id.main_container, new MainFragment(), false);
  }

  private void startFragment(int resId, Fragment fragment, boolean addToBackStack) {

    if (addToBackStack) {

      getSupportFragmentManager()
          .beginTransaction()
          .replace(resId, fragment)
          .addToBackStack(null)
          .commit();
    } else {

      getSupportFragmentManager()
          .beginTransaction()
          .replace(resId, fragment)
          .commit();
    }


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
        startFragment(R.id.main_container, new SettingsFragment(), true);
        break;
    }

    return super.onOptionsItemSelected(item);
  }

  private void initToolbar() {

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }
}
