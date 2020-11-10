package com.trichain.functionsphp.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.trichain.functionsphp.R;
import com.trichain.functionsphp.retrofit.network.ApiService;
import com.trichain.functionsphp.retrofit.networkResponse.HomePageResponse;
import com.trichain.functionsphp.util.util;


import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
//ArrayList<Lessonsmodel> lessonsmodels=;
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


/*
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), mFile);

        ProgressRequestBody fileBody = new ProgressRequestBody(mFile, "multipart/form-data", this);
        MultipartBody.Part myFile = MultipartBody.Part.createFormData("post", mFile.getName(), requestFile);
        MultipartBody.Part myFile2 = MultipartBody.Part.createFormData("post", mFile.getName(), fileBody);
        MultipartBody.Part type1 = MultipartBody.Part.createFormData("type", getType(model.getPath()));
        MultipartBody.Part status = MultipartBody.Part.createFormData("status", "active");
        MultipartBody.Part text = MultipartBody.Part.createFormData("text", model.getDescription() == null ? "none" : model.getDescription() );
        MultipartBody.Part tags = MultipartBody.Part.createFormData("tags", getTags());

        service.createPost(currentUser.getToken(), myFile2, type1, status, text, tags)
                .enqueue(new Callback<CreatePostResponse>() {
                    @Override
                    public void onResponse(Call<CreatePostResponse> call, Response<CreatePostResponse> response) {
                        b.btnPost.setClickable(true);
                        if (p!=null&&p.isShowing()){
                            p.dismiss();
                        }
                        if (response.isSuccessful()) {
                            uploadListener.onSuccess();
                            Toast.makeText(NewPostActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            b.progress.setVisibility(View.GONE);
                            b.edtDesc.setText("");
                            b.edtDesc.setText("");
                            hashTag = new ArrayList<>();
                            mediaPath = "";
                            deleteHashTags();
                            Log.e(TAG, "onResponse: " + getType(model.getPath()));
                        } else {
                            uploadListener.onFailure(uploadPos);
                            try {
                                if (response.errorBody() != null) {
                                    Log.e(TAG, "onResponse: " + response.errorBody().string());
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(NewPostActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<CreatePostResponse> call, Throwable t) {
                        uploadListener.onFailure(uploadPos);
                        if (p!=null&&p.isShowing()){
                            p.dismiss();
                        }
                        b.btnPost.setClickable(true);
                        b.progress.setVisibility(View.GONE);
                        Toast.makeText(NewPostActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "onFailure: Failure " + t.getLocalizedMessage());
                    }
                });*/
       
    }
}