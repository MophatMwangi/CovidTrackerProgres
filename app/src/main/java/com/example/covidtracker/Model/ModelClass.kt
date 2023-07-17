package com.example.covidtracker.Model

data class ModelClass (
     //if you are fetching values you have to give it the same number according to the api
     var id: Int,
     var cases : String,
     var todayCases: String,
     var deaths: String,
     var todayDeaths: String,
     var recovered: String,
     var todayRecovered: String,
     var active: String,
     var country: String

    )