package com.example.vladimir.githubapi.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.vladimir.githubapi.R
import com.example.vladimir.githubapi.api.ApiFactory
import com.example.vladimir.githubapi.api.GitHubAPI

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var apiFactory : ApiFactory = ApiFactory()
        var gitHubAPI : GitHubAPI = apiFactory.getUserURL().create(GitHubAPI::class.java)


    }
}
