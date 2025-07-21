package com.example.chapitresept.navigation

sealed interface NavigationType {


    object BottomNavigation : NavigationType
    object NavigationDrawer : NavigationType
    object NavigationRail : NavigationType

}