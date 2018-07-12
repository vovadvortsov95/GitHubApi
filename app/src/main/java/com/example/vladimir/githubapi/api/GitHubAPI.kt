package com.example.vladimir.githubapi.api

import com.example.vladimir.githubapi.model.ItemResponce
import com.example.vladimir.githubapi.model.User
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Path


public interface GitHubAPI {

    @GET("search/users?q={name}")
   public fun getUsersUrl(@Path("name") groupId: String): Call<ItemResponce>

    //https://api.github.com/search/users?q=tom

    @GET("users/{login}")
    fun getUsersInfo(@Path("login") groupId: String): Call<User>

    @GET("/users/{login}/orgs")
    fun getUserCompanies(@Path("login") groupId: String): Call<List<User>>

    @GET("users/{login}/repos")
    fun getUserRepos(@Path("login") groupId: String): Call<List<User>>

 /*   @GET("/search/users?q=language:java+location:lagos")
    fun getItems(): Call<ItemResponse> */
 }