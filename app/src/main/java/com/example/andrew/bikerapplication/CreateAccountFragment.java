package com.example.andrew.bikerapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import java.util.UUID;

/**
 * Created by Andrew on 5/13/2017.
 */

public class CreateAccountFragment extends Fragment {
    private SQLiteDatabase mDatabase;

    private User user;
    private String password;

    public static CreateAccountFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Button submit = (Button)findViewById(R.id.submitLoginInfo);

        //Add lamda functions here to confirm user and retrieve their routes
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAccountFragment.this, CreateRouteFragment.class);
                startActivity(intent);
            }
        });
    }*/

}
