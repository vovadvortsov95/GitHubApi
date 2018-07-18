package com.example.vladimir.githubapi.LiveData

import android.arch.lifecycle.LiveData
import com.example.vladimir.githubapi.api.ApiFactory
import com.example.vladimir.githubapi.api.GitHubAPI
import com.example.vladimir.githubapi.model.*
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

    //TODO : tom -> search name field
    private fun searchUsers(): List<String>? {
        unsubscribe()
        var items: List<String>? = null
        val apiFactory = ApiFactory()
        val service: GitHubAPI = apiFactory.getUserURL().create(GitHubAPI::class.java)
        val call: Call<ResponceURL> = service.getUsersUrl("tom")
        call.enqueue(object : Callback<ResponceURL> {

            override fun onResponse(call: Call<ResponceURL>?, response: Response<ResponceURL>?) {
                if (response!!.body() != null) {
                    items = response.body()!!.login!!
                }

            }

            override fun onFailure(call: Call<ResponceURL>?, t: Throwable?) {
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

        var users: List<User>? = null
        val userList = searchUsers()
        if (userList != null) {
            for (user in userList) {
                val apiFactory = ApiFactory()
                val service: GitHubAPI = apiFactory.getUserInfo().create(GitHubAPI::class.java)
                val call: Call<User> = service.getUsersInfo(user)
                call.enqueue(object : Callback<User> {

                    override fun onResponse(call: Call<User>?, response: Response<User>?) {
                        if (response!!.body() != null) {
                            users = response.body()!!.getUser()
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

   private fun searchUserRepos(user: User) {

        val name = User().login
        var repos: UserInfo? = null
        if (name != null) {
            val apiFactory = ApiFactory()
            val service: GitHubAPI = apiFactory.getUserRepos().create(GitHubAPI::class.java)
            val call: Call<UserInfo> = service.getUserRepos(name)
            call.enqueue(object : Callback<UserInfo> {
                override fun onResponse(call: Call<UserInfo>?, response: Response<UserInfo>?) {
                    if (response!!.body() != null)
                        repos = response.body()!!.info

                }

                override fun onFailure(call: Call<UserInfo>?, t: Throwable?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })

        }
    }


  private  fun searchUserCompanies(user: User){

        val name = User().login
        var repos: UserInfo? = null
        if (name != null) {
            val apiFactoryComp = ApiFactory()
            val serviceComp: GitHubAPI = apiFactoryComp.getUserCompanies().create(GitHubAPI::class.java)
            val callComp: Call<UserCompanies> = serviceComp.getUserCompanies(name)
            callComp.enqueue(object : Callback<UserCompanies> {
                override fun onResponse(call: Call<UserCompanies>?, response: Response<UserCompanies>?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onFailure(call: Call<UserCompanies>?, t: Throwable?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
    }

    fun userDetailInfo(user : User){
        searchUserRepos(user)
        searchUserCompanies(user)
    }



    private fun unsubscribe() {
        if (subscription != null)
            subscription = null
    }


}
