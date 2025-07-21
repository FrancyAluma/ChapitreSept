package com.example.chapitresept.views

import com.example.chapitresept.data.Cat

data class PetsUIState (

    val isLoading : Boolean = false,
    val pets : List <Cat> = emptyList(),
    val error : String? = null

)