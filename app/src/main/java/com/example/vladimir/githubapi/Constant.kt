package com.example.vladimir.githubapi

import com.example.vladimir.githubapi.api.ApiFactory

class Constant {

    companion object {
        var baseURL : String = "https://api.github.com"
        var api : ApiFactory = ApiFactory().getUserURL().create(ApiFactory::class.java)
    }

    //var api : ApiFactory = ApiFactory()
    //api.getUrl.create()

}