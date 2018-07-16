package com.example.vladimir.githubapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class ResponceURL (
    @SerializedName("login")
    @Expose
    var login: List<String>? = null){

    public fun getUserLogin(): List<String>? {
        return login
    }

}
