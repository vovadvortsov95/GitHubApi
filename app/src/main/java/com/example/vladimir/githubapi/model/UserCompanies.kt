package com.example.vladimir.githubapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserCompanies(@SerializedName("login") @Expose var userOrgs: List<String>?)
