package com.example.vladimir.githubapi.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.vladimir.githubapi.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun bind(user: User?) {
        //itemView.userAvatar = User!!.imageURL
        itemView.login.text = user!!.login
        itemView.name.text = user!!.name
        itemView.repos.text = user!!.repos.toString()
    }

}