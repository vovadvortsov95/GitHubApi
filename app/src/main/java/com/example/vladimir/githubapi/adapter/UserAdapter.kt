package com.example.vladimir.githubapi.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.vladimir.githubapi.R
import com.example.vladimir.githubapi.model.User


class UserAdapter(var data: List<User>?) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }


    override fun getItemCount(): Int {
        return data!!.size
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(data!![position])
    }

}