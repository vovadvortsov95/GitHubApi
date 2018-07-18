package com.example.vladimir.githubapi.model

class UserDetailInfo(
        var userAvatar: String,           // by User
        var name: String,                 // by User
        var login: String,                // by User

        var userCompanies: List<String>?, // by user Companies class

        var listRepos: List<UserRepos>
//        var reposName: String,            // by User Repos
//        var description: String,          // by User Repos can be null
//        var language: String,             // by User Repos can be null
//        var stars: String,                // by User Repos can be null
//        var branch: String,               // by User Repos can be null
//        var updateTime: String            // by User Repos not null?
) {

    private var userDetailInfo: UserDetailInfo? = null


    fun createDetailInfo(user: User, listRepos: List<UserRepos>, userCompanies: UserCompanies): UserDetailInfo {
        return UserDetailInfo(
                user.getUserAvatar(),
                user.getUserName(),
                user.getUserLogin(),
                userCompanies.getUserCompanies(),//userCompanies.userOrgs()
                listRepos // not 1 repos name . It`s List< STRING> !!! TODO: возможна ошибка
                )
    }

}