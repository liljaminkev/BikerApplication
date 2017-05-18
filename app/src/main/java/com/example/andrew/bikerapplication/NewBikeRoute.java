package com.example.andrew.bikerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Andrew on 5/13/2017.
 */

public class NewBikeRoute extends AppCompatActivity{

    EditText routeName, startLat, startLong, endLat, endLong;
    String newRoute, newStartLat, newStartLong, newEndLat, newEndLong;
    int newFreq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_create_route);


        Button orderButton = (Button)findViewById(R.id.submitRoute);

        orderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                routeName = (EditText) findViewById(R.id.route_name);
                startLat = (EditText) findViewById(R.id.start_latitude);
                startLong = (EditText) findViewById(R.id.start_longitude);
                endLat = (EditText) findViewById(R.id.end_latitude);
                endLong = (EditText) findViewById(R.id.end_longitude);

                newRoute = routeName.getText().toString();
                newStartLat = startLat.getText().toString();
                newStartLong = startLong.getText().toString();
                newEndLat = endLat.getText().toString();
                newEndLong = endLong.getText().toString();
                newFreq = 0;


                //Plug in lamda functions here then call CreateRouteFragment.java
                Intent intent = new Intent(NewBikeRoute.this, CreateRouteFragment.class);
                intent.putExtra("routeName", newRoute);
                intent.putExtra("routeStartLat", newStartLat);
                intent.putExtra("routeStartLong", newStartLong);
                intent.putExtra("routeEndLat", newEndLat);
                intent.putExtra("routeEndLong", newEndLong);
                intent.putExtra("routeUsed", newFreq);
                startActivity(intent);
            }
        });

    }
}
