package com.example.vladimir.githubapi.api

import com.example.vladimir.githubapi.model.User
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.lang.reflect.Type

class GitHubDeserializer : JsonDeserializer<User> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): User? {
        if (json != null) {
            // retrofit = Retrofit



        }
        return null
    }
}
/*return User(
                    // private var url : String ? = null
                    //          json.asJsonObject private var login : String? = null,
                    //   private var name : String? = null,
                    //    private var imageURL : String? = null,
                    //   private var totalStars : Int? = null,
                    //    private var totalRepositories : Int? = null
                    json.asJsonObject.get("login").asString,
                    json.asJsonObject.get("avatar_url").asString
            ) */