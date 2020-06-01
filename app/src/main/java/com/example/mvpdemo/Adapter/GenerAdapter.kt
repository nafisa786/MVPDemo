package com.example.mvpdemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpdemo.GenereListResponse
import com.example.mvpdemo.R
import com.example.mvpdemo.databinding.RowGenerListBinding

class GenerAdapter(private val context: Context, private val message: List<GenereListResponse>?): RecyclerView.Adapter<GenerAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: RowGenerListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding:  RowGenerListBinding=
            DataBindingUtil.inflate(inflater, R.layout.row_gener_list, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return message!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        Glide.with(context)
            .load(message!!.get(position).image)
            .dontAnimate()
            .into(binding.imgBusiness);
        binding.txtBusinessName.setText(message.get(position).genresName);
    }

}
