package com.example.vladimir.githubapi.LiveData

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.vladimir.githubapi.api.ApiFactory
import com.example.vladimir.githubapi.api.GitHubAPI
import com.example.vladimir.githubapi.model.ItemResponce
import com.example.vladimir.githubapi.model.User
import org.reactivestreams.Subscription
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersLiveData : LiveData<ItemResponce>() {
    var subscription: Subscription? = null


    private object Holder {
        var INSTANCE = UsersLiveData()
    }

    companion object {
        val instance: UsersLiveData by lazy { Holder.INSTANCE }
    }

    override fun onActive() {
        super.onActive()
        searchUsers()
    }

    override fun onInactive() {
        super.onInactive()
        unsubscribe()
    }


    private fun searchUsers(): List<User>? {
        unsubscribe()
        var items: List<User>? = null
        val apiFactory = ApiFactory()
        val service: GitHubAPI = apiFactory.getUserURL().create(GitHubAPI::class.java)
        val call: Call<ItemResponce> = service.getUsersUrl("tom") // ItemResponce > StringUrls
        call.enqueue(object : Callback<ItemResponce> {

            override fun onResponse(call: Call<ItemResponce>?, response: Response<ItemResponce>?) {
                if (response!!.body() != null) {
                    items = response.body()!!.items  //ItemResponce()
                }

            }

            override fun onFailure(call: Call<ItemResponce>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
        return if (items!!.isNotEmpty()) {
            items
        } else {
            null
        }
        // subscription = ApiFactory().getUserInfo()

    }

    fun searchUserInfo() {

        val users : MutableList<User>?= null
        val userList = searchUsers()
        if (userList != null) {
            for (user in userList) {
                val apiFactory = ApiFactory()
                val service: GitHubAPI = apiFactory.getUserInfo().create(GitHubAPI::class.java)
                val call: Call<User> = service.getUsersInfo(user.toString())
                call.enqueue(object : Callback<User> {

                    override fun onResponse(call: Call<User>?, response: Response<User>?) {
                        if(response!!.body() != null){
                           users!!.add(response.body()!!.getUser()) // i know i`m retard
                        }

                    }

                    override fun onFailure(call: Call<User>?, t: Throwable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }
        } else {
            //Error UserList is Empty
        }


    }

    private fun unsubscribe() {
        if (subscription != null)
            subscription = null
    }

}


