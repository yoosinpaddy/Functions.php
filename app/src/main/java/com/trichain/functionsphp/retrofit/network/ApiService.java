package com.trichain.functionsphp.retrofit.network;


import com.trichain.functionsphp.retrofit.networkResponse.AuthResponse;
import com.trichain.functionsphp.retrofit.networkResponse.CreatePostResponse;
import com.trichain.functionsphp.retrofit.networkResponse.HomePageResponse;
import com.trichain.functionsphp.retrofit.networkResponse.SearchResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiService {
    /*Register anonymous account*/
    @POST("anonymousregister")
    Call<AuthResponse> anonymousLogin();


    /*Retrieve posts for homepage*/
    @GET("post/index")
    Call<HomePageResponse> getHomePagePosts(
            @Header("Authorization") String AUTH_TOKEN
    );



    /*Retrieve Search Results*/
    @GET("search-posts/{keyword}")
    Call<SearchResponse> getSearchResults(
            @Header("Authorization") String AUTH_TOKEN,
            @Path("keyword") String keyword
    );


    /*Add post*/
    @Multipart
    @POST("post/upload")
    Call<CreatePostResponse> createPost(
            @Header("Authorization") String authorization,
            @Part() MultipartBody.Part file,
            @Part() MultipartBody.Part file_type,
            @Part() MultipartBody.Part status,
            @Part() MultipartBody.Part description,
            @Part() MultipartBody.Part tags
    );/*Add post
    @Multipart
    @POST("post/upload")
    Call<CreatePostResponse> createPost(
            @Header("Authorization") String authorization,
            @Part() MultipartBody.Part file,
            @Part("type") String file_type,
            @Part("status") String status,
            @Part("text") String description,
            @Part("tags") String tags
    );*/



}
