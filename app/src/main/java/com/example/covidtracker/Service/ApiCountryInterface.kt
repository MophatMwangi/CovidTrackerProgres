package com.example.covidtracker.Service


import com.example.covidtracker.Model.ModelClass
import retrofit2.Call
import retrofit2.http.GET

interface ApiCountryInterface {

    @GET("countries")
    fun getCountryData(): Call<List<ModelClass>>
}