package com.example.vladimir.githubapi.api

import com.example.vladimir.githubapi.Constant
import com.example.vladimir.githubapi.model.User
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {


    fun getUserURL(): Retrofit { // retrofit builder
        return Retrofit.Builder()
                .baseUrl(Constant.baseURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Retrofit::class.java)
    }

    fun getUserInfo(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constant.baseURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Retrofit::class.java)
    }

    fun getUserCompanies() : Retrofit{
        return Retrofit.Builder()
                .baseUrl(Constant.baseURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Retrofit::class.java)
    }

    fun getUserRepos() : Retrofit{
        val gson = GsonBuilder().registerTypeAdapter(User::class.java,GitHubDeserializer())
        return Retrofit.Builder()
                .baseUrl(Constant.baseURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson.create()))
                .build()
                .create(Retrofit::class.java)
    }

}
