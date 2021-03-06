package com.moon.booklove_android.view.main.myPage.editGender

import android.content.Context
import com.moon.booklove_android.data.dto.UserInputInfoReqDTO

interface EditGenderContract {
    interface View {
        fun init()
        fun selectMan()
        fun selectWoman()
        fun selectComplete()
    }
    interface Presenter {
        var view: View
        fun updateUserGender(userInputInfoReqDTO: UserInputInfoReqDTO, context: Context)
    }
}