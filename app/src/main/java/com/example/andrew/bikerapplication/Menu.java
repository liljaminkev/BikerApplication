/*package com.example.andrew.bikerapplication;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public abstract class Menu extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar.NavigationMode = ActionBarNavigationMode.Tabs;

        setContentView(R.layout.activity_biker_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, CreateAccountFragment.class);
        spec = tabHost.newTabSpec("First").setIndicator("CreateAccountFragment")
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, RouteListFragment.class);
        spec = tabHost.newTabSpec("Second").setIndicator("RouteListFragment")
                .setContent(intent);
        tabHost.addTab(spec);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

}
*/