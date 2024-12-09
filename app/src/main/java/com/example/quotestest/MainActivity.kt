package com.example.quotestest

import android.content.Loader
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quotestest.screens.QuoteList
import com.example.quotestest.ui.theme.QuotesTestTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        //This Coroutine will be run in the background
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            DataManager.readDataFromFile(applicationContext)
        }

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
    else{
        LoadingIndicator()
    }
}


@Composable
fun LoadingIndicator() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}