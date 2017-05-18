package com.example.andrew.bikerapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.andrew.bikerapplication.database.UserBaseHelper;
import com.example.andrew.bikerapplication.database.UserCursorWrapper;
import com.example.andrew.bikerapplication.database.UserDbSchema;

import static com.example.andrew.bikerapplication.database.UserDbSchema.UserTable.Cols.PASSWORD;
import static com.example.andrew.bikerapplication.database.UserDbSchema.UserTable.Cols.USERID;

/**
 * Created by kevinchan on 5/16/17.
 */

public class User {
    private static User sUser;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private String login;
    private String firstName;
    private String lastName;
    private String userID;
    private String password;

    public static User get(Context context){
        if(sUser == null){
            sUser = new User(context);
            //return sUser;
        }
        return sUser;
    }


    private User(Context context){
        //mContext = context.getApplicationContext();
        //mDatabase = new UserBaseHelper(mContext).getWritableDatabase();

    }

    public void getUser(){
        UserCursorWrapper cursor = queryUser(null, null);

        try {
            if(cursor.getCount() == 0){

            }
            cursor.moveToFirst();
            sUser = cursor.getUser(sUser);
        }finally {
            cursor.close();
        }
    }

    private UserCursorWrapper queryUser(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                UserDbSchema.UserTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new UserCursorWrapper(cursor);
    }

    public void updateUser(){
        ContentValues values = getContentValues(sUser);
    }



    private static ContentValues getContentValues(User user) {
        ContentValues values = new ContentValues();
        values.put(USERID, user.getUserID());
        values.put(PASSWORD, user.getPassword());
        return values;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
