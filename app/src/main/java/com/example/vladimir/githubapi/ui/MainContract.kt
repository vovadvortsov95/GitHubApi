package com.example.vladimir.githubapi.ui

import android.os.Bundle
import com.example.vladimir.githubapi.model.ItemResponce

interface MainContract {

    interface View {

        fun updateData(t : ItemResponce){

        }

    fun update()

    }

    interface Presenter{

        fun onCreate(savedInstanceState: Bundle?)

        fun onStart()

        fun onStop()

    }

}