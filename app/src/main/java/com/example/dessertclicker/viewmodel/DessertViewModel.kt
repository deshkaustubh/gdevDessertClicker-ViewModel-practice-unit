package com.example.dessertclicker.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.R
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        DessertUiState(
            revenue = 0,
            dessertsSold = 0,
            currentDessertPrice = 0,
            currentDessertImage = R.drawable.cupcake
        )
    )

    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    init {
        val firstDessert = Datasource.dessertList.first()

        // update withe initial values from the data source dessertList
        _uiState.value = DessertUiState(
            revenue = 0,
            dessertsSold = 0,
            currentDessertPrice = firstDessert.price,
            currentDessertImage = firstDessert.imageId
        )
    }

    fun onDessertClicked() {
        _uiState.update { cupcakeUiState ->
            val dessertsSold = cupcakeUiState.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertsSold)
            cupcakeUiState.copy(
                revenue = cupcakeUiState.revenue + cupcakeUiState.currentDessertPrice,
                dessertsSold = dessertsSold,
                currentDessertImage = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price
            )
        }
    }

    private fun determineDessertIndex(dessertSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more
                // desserts, you'll start producing more expensive desserts as determined by
                // startProductionAmount. We know to break as soon as we see a dessert who's
                // "startProductionAmount" is greater than the amount sold.
                break
            }
        }
        return dessertIndex
    }
}


/*
Learnings:
The init block is a special block in Kotlin that runs when an instance of the class is created. It's perfect for setting up your initial state.  This approach ensures you're using the correct initial dessert data from your Datasource instead of hardcoding values like you currently have with R.drawable.cupcake.

 */