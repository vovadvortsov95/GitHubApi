package com.example.vladimir.githubapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User(
        @SerializedName("login") @Expose val login: String? = null,
        @SerializedName("name") @Expose val name: String? = null,
        @SerializedName("avatar_url") @Expose val imageURL: String? = null,
        // @Expose  val totalStars : Int? = null,
        @SerializedName("public_repos") @Expose val repos: Int? = null) {

    var url: String? = null
    private lateinit var listUser: List<User>
    public fun getUser(): List<User> {
        return listUser
    }

    public fun getUserUrl(): String? {
        return url
    }

    fun getUserName(): String {
        if (name != null) {
            return name
        }
        else return " "
    }

    fun getUserLogin(): String {
        if (login != null) {
            return login
        }
        else return " "
    }

    fun getUserAvatar(): String {
        if (imageURL != null) {
            return imageURL
        }
        else return " "
    }

}
