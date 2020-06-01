package com.example.mvpdemo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class GenereListResponse {
    @SerializedName("genres_id")
    @Expose
    var genresId: Int? = null
    @SerializedName("genres_name")
    @Expose
    var genresName: String? = null
    @SerializedName("image")
    @Expose
    var image: String? = null
    @SerializedName("total_count")
    @Expose
    var totalCount: Int? = null

}

class GenereResponse {
    @SerializedName("status")
    @Expose
    var status: Int? = null
    @SerializedName("data")
    @Expose
    var data: List<GenereListResponse>? = null
    @SerializedName("msg")
    @Expose
    var msg: String? = null

}