package com.example.chapitresept.navigation

sealed class Screens ( val route : String ){

    object PetsScreen : Screens ("pets")
    object PetDetailsScreen : Screens ("petsDetails")
    object FavoritePetsScreen : Screens ("favoritePets")

}