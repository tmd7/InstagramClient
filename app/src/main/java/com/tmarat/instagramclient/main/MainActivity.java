package com.tmarat.instagramclient.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.tmarat.instagramclient.R;
import com.tmarat.instagramclient.about.AboutActivity;
import com.tmarat.instagramclient.model.Preferences;
import com.tmarat.instagramclient.settings.SettingsFragment;
import com.tmarat.instagramclient.util.ActivityUtils;
import com.tmarat.instagramclient.util.ConstantsUtil;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    int themeResId = new Preferences().getPreferences(this, ConstantsUtil.THEME_KEY);
    setTheme(themeResId);
    setContentView(R.layout.activity_main);

    setNavigationDrawer();

    if (savedInstanceState == null) {
      ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(),
          MainFragment.newInstance(), R.id.main_container);
    }
  }

  private void setNavigationDrawer() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_settings:
        ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(),
            SettingsFragment.newInstance(), R.id.main_container);
        break;

      default:
        break;
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    switch (item.getItemId()) {

      case R.id.nav_home:
        ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(),
            MainFragment.newInstance(), R.id.main_container);
        break;

      case R.id.nav_settings:
        ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(),
            SettingsFragment.newInstance(), R.id.main_container);
        break;

      case R.id.nav_about:
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
      default:
        break;
    }


    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }
}
