package com.example.jhonjaroltabaresorozco.retrofitexample.http.apimodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Sport {

    @SerializedName("idSport")
    @Expose
    var idSport: String? = null
    @SerializedName("strSport")
    @Expose
    var strSport: String? = null
    @SerializedName("strSportThumb")
    @Expose
    var strSportThumb: String? = null
    @SerializedName("strSportDescription")
    @Expose
    var strSportDescription: String? = null

}

