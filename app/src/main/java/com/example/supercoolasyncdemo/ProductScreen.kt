package com.example.supercoolasyncdemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProductenScreen(modifier: Modifier = Modifier, viewModel: ProductViewModel = viewModel()) {
    var showProducts by remember { mutableStateOf(false) }
    var products by remember { mutableStateOf(viewModel.products) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showProducts) {

            ProductList(products)

        } else {
            Button(onClick = { showProducts = true }) {
                Text("Show Products")
            }
        }
    }
}