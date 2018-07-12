package com.example.vladimir.githubapi.ui

import android.os.Bundle
import com.example.vladimir.githubapi.model.ItemResponce

class MainPresenter(var view : MainContract.View) : MainContract.Presenter {

    override fun onCreate(savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onResponce(t : ItemResponce){
        view.updateData(t)
    }

}