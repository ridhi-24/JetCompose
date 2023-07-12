package com.example.jetcompose


data class User(val description: String)


fun dummyData(): List<User> {
    return listOf(User("jetpack"), User("android"), User("less code"))
}
