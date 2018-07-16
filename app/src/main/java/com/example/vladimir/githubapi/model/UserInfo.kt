package com.example.vladimir.githubapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserInfo(
    @SerializedName(" ") @Expose var name : String,
    @SerializedName(" ") @Expose var description : String ,
    @SerializedName(" ") @Expose var language: String,
    @SerializedName(" ") @Expose var stars :Int ,
    @SerializedName(" ") @Expose var  branch: Int ){

   lateinit var info : UserInfo
}