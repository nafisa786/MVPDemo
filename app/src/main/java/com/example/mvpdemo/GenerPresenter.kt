package com.example.mvpdemo

import android.app.Activity
import com.example.mvpdemo.Activity.Home

class GenerPresenter(private val activity: Activity):Impl.OnFinishedListener{

    private val varimplementaion: Implementation = Implementation()
    fun setGener(body: HashMap<String, String>) {
        varimplementaion.setGener(activity, body, this)
    }
    override fun onError(error: String) {
        (activity as Home).onGenerError(error)
    }

    override fun onSuccess(message: GenereResponse?) {
        (activity as Home).onGenerResponse(message)
    }

}