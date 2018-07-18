package com.example.vladimir.githubapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class UserCompanies(@SerializedName("login") @Expose val userOrgs: List<String>?)
{
    fun getUserCompanies(): List<String>{
        if(userOrgs != null){
            return userOrgs
        } else { return Arrays.asList(" ")}
    }
}
