package com.example.mvvmbasicstrcture.helper

import BaseViewModel
import android.app.Application
import androidx.lifecycle.MutableLiveData

/**
 * Here we have Use Event class for emitting value only for once.
 * once the value is emitted it will not Emit again.
 *
 * set Message Method is used for communicate with View Class.
 *
 * observedChanges() method used for observing changes in messageString
 *
 * */

class JustCopyItVIewModel(val context: Application) : BaseViewModel(context) {


    private var messageString = MutableLiveData<String>()

    private fun setMessage(msg: String) {
        messageString.value = msg
    }

    fun observedChanges() = messageString
}