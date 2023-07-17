package com.example.covidtracker.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covidtracker.Model.ModelClass
import com.example.covidtracker.R
import com.google.android.material.internal.ContextUtils.getActivity
import java.text.NumberFormat


class MyAdapter(nctx : Context, val countryList: List<ModelClass> ):  RecyclerView.Adapter<MyAdapter.AdapterViewHolder>()   {
    var isOnTextChanged  =false
    
    var m = 1
    inner class AdapterViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        var cases = view.findViewById<TextView>(R.id.countrycase)
        var countryname = view.findViewById<TextView>(R.id.countryname)
        var Etext = view.findViewById<EditText>(R.id.Editcountrycase)
        var watcher: TextWatcher? = null
        fun bindData(myCountries: ModelClass) {
            cases.text = myCountries.cases
            countryname.text = myCountries.country

        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        )

        override fun onBindViewHolder(holder: MyAdapter.AdapterViewHolder, position: Int) {
            val countries = countryList[position]

            holder.bindData(countries)
            holder.Etext.setOnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) {
                    countries.cases = holder.Etext.text.toString()
                    countries.recovered = holder.Etext.text.toString()
                    countries.deaths = holder.Etext.text.toString()
                    countries.active = holder.Etext.text.toString()
                }
            }

            if (m == 1) {
                holder.Etext.setText(countryList.get(position).cases)
                holder.cases.text =NumberFormat.getInstance().format(Integer.parseInt(countries.cases))
            } else if (m == 2) {
                holder.Etext.setText(countries.recovered)
                holder.cases.text =NumberFormat.getInstance().format(Integer.parseInt(countries.recovered))
            } else if (m == 3) {

                holder.Etext.setText(countries.deaths)
                holder.cases.text =NumberFormat.getInstance().format(Integer.parseInt(countries.deaths))
            } else {
                holder.Etext.setText(countries.active)
                holder.cases.text = NumberFormat.getInstance().format(Integer.parseInt(countries.active))
            }
            //holder.cases.text = countries.country

        }

        override fun getItemCount(): Int {
            return countryList.size
        }

        @SuppressLint("NotifyDataSetChanged")
        fun filter(charText: String) {
            if (charText.equals("cases")) {
                m = 1
            } else if (charText.equals("recovered")) {
                m = 2
            } else if (charText.equals("deaths")) {
                m = 3
            } else {
                m = 4
            }
            notifyDataSetChanged()
        }

}