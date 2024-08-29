package com.example.supercoolasyncdemo

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductViewModel : ViewModel() {

    val productService: ProductService = ProductService()

    private val _products = mutableStateListOf<ProductDTO>()
    val products: List<ProductDTO> = _products


    init {
        viewModelScope.launch {
            val fetchedProducts = withContext(Dispatchers.IO) {
                fetchProducts()
            }

            _products.addAll(fetchedProducts)
        }
    }

    private suspend fun fetchProducts(): List<ProductDTO> {
        return productService.getProducts() ?: emptyList()
    }
}