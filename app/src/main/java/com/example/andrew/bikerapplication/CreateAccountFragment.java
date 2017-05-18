package com.example.andrew.bikerapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Andrew on 5/13/2017.
 */

public class CreateAccountFragment extends Fragment {

    private static final String ARG_USER_ID = "user_id";

    private User mUser;
    private EditText mPasswordField;
    private EditText mFirstNameField;
    private EditText mLastNameField;
    private EditText mLoginField;

    public static CreateAccountFragment newInstance() {
        Bundle args = new Bundle();
        //args.putSerializable(ARG_USER_ID, userID);

        CreateAccountFragment fragment = new CreateAccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        String userID = (String) getArguments().getSerializable(ARG_USER_ID);
        mUser = User.get(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_create_account, container, false);


        mLoginField = (EditText) v.findViewById(R.id.emailInput);
        mLoginField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setLogin(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mFirstNameField = (EditText) v.findViewById(R.id.firstNameInput);
        mFirstNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLastNameField = (EditText) v.findViewById(R.id.lastNameInput);
        mLastNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPasswordField = (EditText) v.findViewById(R.id.passwordInput);
        mPasswordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return v;
    }


    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_create_account);
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
