package com.example.andrew.bikerapplication;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class TabActivity extends android.app.TabActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_biker_main);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, CreateAccountFragment.class);
        spec = tabHost.newTabSpec("First").setIndicator("CreateAccountFragment")
                .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, CreateRouteFragment.class);
        spec = tabHost.newTabSpec("Second").setIndicator("Route")
                .setContent(intent);
        tabHost.addTab(spec);
    }

}
