package com.example.quotestest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.quotestest.screens.QuoteList
import com.example.quotestest.ui.theme.QuotesTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        DataManager.readDataFromFile(this)

        setContent {
            QuotesTestTheme {
                App()
            }
        }
    }
}


@Composable
fun App(modifier: Modifier = Modifier) {
    if(DataManager.isDataLoaded.value == true){
        QuoteList(DataManager.data) { }
    }
}