package com.trichain.functionsphp.retrofit.networkResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import com.trichain.kenyasihami.models.PostModel;

public class CreatePostResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
  /*  @SerializedName("post")
    @Expose
    private PostModel post;*/

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
/*
    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }*/
}
