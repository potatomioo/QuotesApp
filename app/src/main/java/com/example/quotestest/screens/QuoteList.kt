package com.example.quotestest.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotestest.Models.QuotesItem


@Composable
fun QuoteList(data : Array<QuotesItem>,onClick:() -> Unit) {
    LazyColumn(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        items(data){item->
            QuoteCard(item) { onClick() }
        }
    }
}