package com.example.andrew.bikerapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by kevinchan on 5/16/17.
 */

public class RouteListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new RouteListFragment();
    }

}