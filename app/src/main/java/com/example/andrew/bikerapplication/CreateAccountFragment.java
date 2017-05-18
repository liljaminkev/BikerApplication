package com.example.andrew.bikerapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

/**
 * Created by Andrew on 5/13/2017.
 */

public class CreateAccountFragment extends Fragment {

    private User user;
    private String password;


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
    }

}
