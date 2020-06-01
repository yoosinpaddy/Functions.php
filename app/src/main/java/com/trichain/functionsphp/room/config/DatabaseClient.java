package com.trichain.functionsphp.room.config;

import android.content.Context;

import androidx.room.Room;




public class DatabaseClient {

    private Context context;
    String dbName="GameDb";


    private static DatabaseClient databaseClient;

    //DB object
    private AppDatabase appDatabase;

    private DatabaseClient(Context context){
        this.context=context;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, dbName).build();
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        if (databaseClient == null) {
            databaseClient = new DatabaseClient(context);
        }
        return databaseClient;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
