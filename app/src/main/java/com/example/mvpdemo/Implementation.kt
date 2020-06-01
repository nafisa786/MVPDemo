package com.example.mvpdemo

import android.content.Context
import com.example.mvpdemo.Retrofit.ApiInterface
import com.example.mvpdemo.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class Implementation:Impl {

    private var context: Context? = null
    private var listener: Impl.OnFinishedListener? = null
    private var apiInterface: ApiInterface?=null

    override fun setGener(
        context: Context,
        body: HashMap<String, String>,
        listener: Impl.OnFinishedListener)
    {
        this.context = context
        this.listener = listener

        apiInterface = RetrofitClient.getClient()!!.create(ApiInterface::class.java)
        val genereResponseCall=apiInterface!!.generresponse()

        genereResponseCall.enqueue(object : Callback<GenereResponse> {
            override fun onResponse(call: Call<GenereResponse>, response: Response<GenereResponse>) {
                if (response.isSuccessful)
                {
                   listener.onSuccess(response.body())
                } else {
                    listener.onError(response.message())
                }
            }

            override fun onFailure(call: Call<GenereResponse>, t: Throwable) {
                listener.onError(t.localizedMessage)
            }
        })

    }
}