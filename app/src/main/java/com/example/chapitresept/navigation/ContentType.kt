package com.example.chapitresept.navigation

sealed interface ContentType {

    object List : ContentType
    object ListAndDetail : ContentType
}