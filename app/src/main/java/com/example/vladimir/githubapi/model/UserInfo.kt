package com.example.vladimir.githubapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserInfo(
    @SerializedName("name") @Expose var name : String,
    @SerializedName("description") @Expose var description : String ,
    @SerializedName("language") @Expose var language: String,
    @SerializedName("stargazers_count") @Expose var stars :Int ,
    @SerializedName("forks_count") @Expose var  branch: Int,
    @SerializedName("pushed_at") @Expose var updateTime: String){

   lateinit var info : UserInfo
}