package com.example.andrew.bikerapplication.database;

/**
 * Created by kevinchan on 5/17/17.
 */

public class UserDbSchema {
    public static final class UserTable {
        public static final String NAME = "users";

        public static final class Cols {
            public static final String USERID = "userid";
            public static final String PASSWORD = "password";
        }
    }
}
