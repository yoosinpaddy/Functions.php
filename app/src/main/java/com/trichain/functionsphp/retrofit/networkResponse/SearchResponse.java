package com.trichain.functionsphp.retrofit.networkResponse;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    /*@SerializedName("post")
    @Expose
    private List<PostModel> post = null;
    @SerializedName("user")
    @Expose
    private List<User> user = null;*/

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   /* public List<PostModel> getPost() {
        return post;
    }

    public void setPost(List<PostModel> post) {
        this.post = post;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }*/
}
