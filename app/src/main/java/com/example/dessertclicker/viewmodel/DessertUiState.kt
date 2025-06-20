package com.example.dessertclicker.viewmodel

data class DessertUiState (
    var revenue: Int,
    var dessertsSold : Int,
    var currentDessertPrice: Int,
    var currentDessertImage : Int
    )


/*
Learnings:

    You've included the key properties we discussed:
revenue
dessertSold
currentDessertPrice
For the image, you've used currentDessertImage as a String type. However, in the original code, the image is represented by a resource ID (Int). The Dessert class uses imageId: Int to refer to drawable resources.
You've created a regular class rather than a data class. In Kotlin, data classes automatically provide useful functionality like toString(), equals(), hashCode(), and copy() methods which are helpful for immutable state objects.
The properties are mutable (var instead of val). When working with UI state in a ViewModel pattern, it's often recommended to use immutable properties to prevent unexpected state changes.
 */