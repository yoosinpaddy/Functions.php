package com.trichain.functionsphp.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.trichain.functionsphp.R;
import com.trichain.functionsphp.retrofit.network.ApiService;
import com.trichain.functionsphp.retrofit.networkResponse.HomePageResponse;
import com.trichain.functionsphp.util.util;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ApiService service;
    //Gson
//    implementation 'com.google.code.gson:gson:2.8.6'

    //Retrofit
//    implementation 'com.squareup.retrofit2:retrofit:2.7.2'
//    implementation 'com.squareup.retrofit2:converter-gson:2.7.2'
//    implementation 'com.squareup.okhttp3:okhttp:4.3.1'
//    implementation("com.squareup.okhttp3:logging-interceptor:4.3.1")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        service = util.getApiService();
    }
    private void downloadPosts() {
        Log.e(TAG, "downloadPosts: ");
            service.getHomePagePosts("currentUser.getToken()")
                    .enqueue(new Callback<HomePageResponse>() {
                        @Override
                        public void onResponse(Call<HomePageResponse> call, Response<HomePageResponse> response) {
//                            util.hideView(b.pbPostsLoading, true);
//                            b.srlHome.setRefreshing(false);
                            if (response.isSuccessful()) {
//                                postModelList.clear();
                                if (!response.body().getError()) {
                                    //Log.e(TAG, "onResponse: Posts: " + response.body().getPost().toString());
                                    //postModelList.addAll(response.body().getPost());
//                                    for (PostModel a : response.body().getPost()) {
//                                        checkIfPostExists(new PostListTable(a));
//                                    }
                                } else {
                                    //Logger.logThis(LOG_I, "fillData()", "Failed: " + response.body().getMessage(), util.getLineNumber());
                                }
                            } else {
                                //Logger.logThis(LOG_E, "fillData()", "Unsuccessful " + response.code(), util.getLineNumber());
                            }
                        }

                        @Override
                        public void onFailure(Call<HomePageResponse> call, Throwable t) {
//                            b.srlHome.setRefreshing(false);
//                            util.hideView(b.pbPostsLoading, true);
                            //Logger.logThis(LOG_E, "fillData()", "Fatal Failure: " + t.getLocalizedMessage(), util.getLineNumber());
                        }
                    });
       
    }
}