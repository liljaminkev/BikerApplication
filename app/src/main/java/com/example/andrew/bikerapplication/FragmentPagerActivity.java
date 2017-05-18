package com.example.andrew.bikerapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kevin on 5/18/17.
 */

public class FragmentPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager);

        mViewPager = (ViewPager) findViewById(R.id.activity_view_pager);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new ActivityFragmentPageAdapter(getSupportFragmentManager(),FragmentPagerActivity.this));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
}
