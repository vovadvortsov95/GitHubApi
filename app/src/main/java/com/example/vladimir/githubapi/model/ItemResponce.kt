package com.example.vladimir.githubapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class ItemResponce(@SerializedName("items")
                          @Expose
                           var items: List<User>)
