package com.example.mvpdemo.Activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpdemo.Adapter.GenerAdapter
import com.example.mvpdemo.GenerPresenter
import com.example.mvpdemo.GenereResponse
import com.example.mvpdemo.R
import com.example.mvpdemo.Retrofit.ApiInterface
import com.example.mvpdemo.Retrofit.RetrofitClient.getClient
import com.example.mvpdemo.databinding.ActivityHomeBinding


class Home : AppCompatActivity() {

    private var generAdapter: GenerAdapter?=null
    private var apiInterface: ApiInterface?=null
    var context:Context?=null
    lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home)
        context=this
        apiInterface = getClient()!!.create(ApiInterface::class.java)
        var genereResponseCall=apiInterface!!.generresponse()
        var hashMap:HashMap<String,String>

        val body = HashMap<String, String>()
        val generepresenter=GenerPresenter(context as Home)
        generepresenter.setGener(body)




    }
    fun onGenerError(error: String) {
        Toast.makeText(context,error,Toast.LENGTH_SHORT).show()
    }

    fun onGenerResponse(message: GenereResponse?) {
        val genereListResponses=message!!.data
        val linearLayoutManager = LinearLayoutManager(context)
        binding.rvCartlist.setLayoutManager(linearLayoutManager)
        generAdapter = GenerAdapter(this@Home, genereListResponses)
        binding.rvCartlist.setAdapter(generAdapter)
        Log.d("mytag", "list size::::" + genereListResponses!!.size)
    }

}
