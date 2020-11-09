package com.trichain.functionsphp.retrofit.networkResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import com.trichain.kenyasihami.models.User;

public class AuthResponse {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
  /*  @SerializedName("user")
    @Expose
    private User user;*/

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
    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

}
