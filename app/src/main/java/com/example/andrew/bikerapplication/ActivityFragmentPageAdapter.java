package com.example.andrew.bikerapplication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.andrew.bikerapplication.CreateAccountFragment;

/**
 * Created by kevin on 5/18/17.
 */

public class ActivityFragmentPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "Login", "Routes"};
    private Context context;

    public ActivityFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        return CreateAccountFragment.newInstance();
        /*else{
            return RouteListFragment.newInstance();
        }*/
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
