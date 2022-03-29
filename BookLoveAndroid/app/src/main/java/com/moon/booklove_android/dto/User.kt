package com.moon.booklove_android.dto

data class User(
    var id: Long,
    var nickname: String,
    var age: Int,
    var gender: String,
    var checked: Boolean,
    var type: String,
    var userId: String,
    var userCategoryList: ArrayList<String>
)
