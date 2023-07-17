package com.example.covidtracker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covidtracker.Adapter.MyAdapter
import com.example.covidtracker.Model.ModelClass
import com.example.covidtracker.Service.ApiCountryInterface
import com.example.covidtracker.Service.RetrofitInstance
import com.hbb20.CountryCodePicker
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.NumberFormat

abstract class MainActivity : AppCompatActivity() {

   /* lateinit var countryCodePicker : CountryCodePicker
    lateinit var mtodaytotal : TextView
    lateinit var mtotal : TextView
    lateinit var mactive : TextView
    lateinit var mtodayactive : TextView
    lateinit var mrecovered : TextView
    lateinit var mtodayrecovered : TextView
    lateinit var mdeaths : TextView
    lateinit var mtodaydeaths: TextView
    lateinit var mfilter : TextView
    lateinit var spinner: Spinner
     /*var countrys : String
         get() {
           return countrys
         }
         set(countrys: String) {
             this.countrys =countrys
         }*/


    var types = arrayOf("cases","deaths","recovered","active")

    var countryList = ArrayList<ModelClass>()
    //var theAdapter = MyAdapter(this,countryList)

    var countryListA = ArrayList<ModelClass>()
    //var theAdapter = MyAdapter(this,countryListA)
    lateinit var mpiechart : PieChart
    lateinit var recylerView :RecyclerView
    lateinit var theAdapter :  RecyclerView.Adapter<MyAdapter.AdapterViewHolder>*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)

        /*countryCodePicker = findViewById(R.id.ccp)
        mtodayactive = findViewById(R.id.todayactive)
        mactive= findViewById(R.id.activecase)
        mdeaths = findViewById(R.id.totaldeaths)
        mtodaydeaths= findViewById(R.id.todaydeaths)
        mrecovered = findViewById(R.id.totalrecovered)
        mtodayrecovered = findViewById(R.id.todayrecovered)
        mtotal = findViewById(R.id.totalcase)
        mtodaytotal = findViewById(R.id.todaytotal)
        mfilter = findViewById(R.id.filter)
        mpiechart = findViewById(R.id.piechart)
        spinner= findViewById(R.id.spinner)







        countryCodePicker.setAutoDetectedCountry(true)
        var country = countryCodePicker.selectedCountryName
        countryCodePicker.setOnCountryChangeListener { object:CountryCodePicker.OnCountryChangeListener {
            override fun onCountrySelected() {
                country = countryCodePicker.selectedCountryName
                fetchData()
            }
        }

        }



        val arrAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,types)
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
         spinner.adapter = arrAdapter

        spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?,view: View?,position: Int,id: Long) {
                val item = types[position]
                mfilter.setText(item)
                //theAdapter.filter(item)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }*/




    }





    /*fun fetchData(){
        val service = RetrofitInstance.getRetrofitInstance().create(ApiCountryInterface::class.java)
        val callCountries = service.getCountryData()
        callCountries.enqueue(object : Callback<List<ModelClass>> {
            override fun onResponse(call: Call<List<ModelClass>>,response: Response<List<ModelClass>>) {
                    //onResponse()

                //countryList.addAll(response.body()!!)

               /* for(i in 0 until countryList.size ){
                    if(countryList.get(i).country.equals(countrys)){
                        mactive.text = NumberFormat.getInstance().format(countryList.get(i).active)
                        mtodaydeaths.text = NumberFormat.getInstance().format(countryList.get(i).todayDeaths)
                        mtodayrecovered.text = NumberFormat.getInstance().format(countryList.get(i).todayRecovered)
                        mtotal.text = NumberFormat.getInstance().format(countryList.get(i).todayCases)
                        mdeaths.text = NumberFormat.getInstance().format(countryList.get(i).deaths)
                        mrecovered.text = NumberFormat.getInstance().format(countryList.get(i).recovered)


                        var active : Int = Integer.parseInt(countryList.get(i).active)
                        var total : Int = Integer.parseInt(countryList.get(i).cases)
                        var recovered: Int = Integer.parseInt(countryList.get(i).recovered)
                        var deaths : Int = Integer.parseInt(countryList.get(i).deaths)

                        updategraph(active, total, recovered, deaths)
                    }


                }*/
                theAdapter = MyAdapter(this@MainActivity, response.body()!!)
                recylerView= findViewById(R.id.recyclerview)
                recylerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recylerView.adapter = theAdapter

               // adapter.notify()

                Log.d("see","message:"+ response.body())
            }

            override fun onFailure(call: Call<List<ModelClass>>, t: Throwable) {

            }
        })

    }

    private fun updategraph(active: Int, total: Int, recovered: Int, deaths: Int) {
        mpiechart.clearChart()
        mpiechart.addPieSlice(PieModel("confirm", total.toFloat(), Color.parseColor("#FF8701")))
        mpiechart.addPieSlice(PieModel("Active", active.toFloat(), Color.parseColor("#FF4CAF50")))
        mpiechart.addPieSlice(PieModel("Recovered",recovered.toFloat(), Color.parseColor("#38ACCD")))
        mpiechart.addPieSlice(PieModel("Deaths", deaths.toFloat(), Color.parseColor("#F55C47")))
        mpiechart.startAnimation()
    }*/


}


