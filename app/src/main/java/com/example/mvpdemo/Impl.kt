package com.example.mvpdemo

import android.content.Context

interface Impl {
    fun setGener(context: Context, body: HashMap<String, String>, listener: OnFinishedListener)

    interface OnFinishedListener {
        fun onError(error: String)
        fun onSuccess(message: GenereResponse?)
    }
}
