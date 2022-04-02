package com.moon.booklove_android.view.main.myPage

import android.content.Context

interface MyPageContract {
    interface View {
        fun init()
    }
    interface Presenter {
        var view: View
        fun userUpdateInfo(nickname: String, context: Context)
    }
}