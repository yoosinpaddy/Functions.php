package com.trichain.functionsphp.retrofit.networkResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.trichain.kenyasihami.models.PostModel;

import java.util.List;

public class HomePageResponse {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("post")
    @Expose
    private List<PostModel> postModels = null;

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

    public List<PostModel> getPost() {
        return postModels;
    }

    public void setPost(List<PostModel> PostModel) {
        this.postModels = PostModel;
    }
}
