package com.example.andrew.bikerapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by kevin on 5/18/17.
 */

public class CreateAccountActivity extends SingleFragmentActivity {

    private static final String EXTRA_USER_ID =
            "com.example.andrew.bikerapplication.user_id";

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, CreateAccountActivity.class);
        intent.putExtra(EXTRA_USER_ID, crimeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        String userID = (String) getIntent()
                .getSerializableExtra(EXTRA_USER_ID);
        return CreateAccountFragment.newInstance();
    }



}
