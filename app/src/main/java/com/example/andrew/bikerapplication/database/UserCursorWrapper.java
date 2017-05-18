package com.example.andrew.bikerapplication.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.andrew.bikerapplication.Route;
import com.example.andrew.bikerapplication.User;
import com.example.andrew.bikerapplication.database.UserDbSchema.UserTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kevin on 5/17/17.
 */

public class UserCursorWrapper extends CursorWrapper {
    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public User getUser(User user) {
        String userID = getString(getColumnIndex(UserTable.Cols.USERID));
        String password = getString(getColumnIndex(UserTable.Cols.PASSWORD));

        user.setUserID(userID);
        user.setPassword(password);

        return user;
    }

}
