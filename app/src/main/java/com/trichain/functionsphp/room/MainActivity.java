package com.trichain.functionsphp.room;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import com.trichain.functionsphp.R;
import com.trichain.functionsphp.room.config.DatabaseClient;

public class MainActivity extends AppCompatActivity {

    //TODO Room components
    //    implementation 'android.arch.persistence.room:runtime:1.1.1'
    //    annotationProcessor 'android.arch.persistence.room:compiler:1.1.1'
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetPoints();

    }
    private void resetPoints() {
        //TODO Must be done in background
        @SuppressLint("StaticFieldLeak")
        class DelPeople extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient
                        .getInstance(MainActivity.this)
                        .getAppDatabase()
                        .peopleDao()
                        .resetPoints();
                return null;
            }

            @Override
            protected void onPostExecute(Void v) {
                //TODO excetcute
            }
        }

        DelPeople gh = new DelPeople();
        gh.execute();
    }
}
