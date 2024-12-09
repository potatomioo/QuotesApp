package com.example.quotestest

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotestest.Models.QuotesItem
import com.google.gson.Gson

object DataManager {


    var data = emptyArray<QuotesItem>()
    var isDataLoaded = mutableStateOf(false)

    fun readDataFromFile(context: Context){
        val inputStream = context.assets.open("quotesSource.Json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<QuotesItem>::class.java)
        isDataLoaded.value = true
    }

}