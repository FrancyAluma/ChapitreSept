package com.example.chapitresept.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.chapitresept.data.Cat
import com.example.chapitresept.views.FavoritePetsScreen
import com.example.chapitresept.views.PetDetailsScreen
import com.example.chapitresept.views.PetsScreen
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

@Composable
fun AppNavigation (

    contentType: ContentType,
    navControlla : NavHostController = rememberNavController()

) {



    /*
    Dans la plupart des cas pour te permettre de ne pas te tromper, c'est :

    val navController = rememberNavController()

    Mais pour nous permettre d'avoir une comprehension profonde de la chose,
    j'ai decide de nommer la variable : val navControlla
     */

   /* val fakeCat = Cat (
        createdAt = "2025-06-29T00:00:00Z",
        id = "123",
        owner = "Francy",
        tags = listOf("cute", "playful", "Siamese"),
        updatedAt = "2025-06-29T00:00:00Z"
    )*/


    NavHost (

        navController = navControlla ,
        startDestination = Screens.PetsScreen.route
            /*"${Screens.PetDetailsScreen.route}/${Json.encodeToString(fakeCat)}"*/

    ) {
       composable(
           Screens.PetsScreen.route
       ) {
           PetsScreen(
               onPetClicked = { cat ->
                   navControlla.navigate(
                       "${Screens.PetDetailsScreen.route}/${Json.encodeToString(cat)}"
                   )
               },
               contentType = contentType
           )
        }

        composable (
           route ="${Screens.PetDetailsScreen.route}/{cat}",
            arguments = listOf(
                navArgument("cat") {
                    type = NavType.StringType
                }
            )

        ) {
            PetDetailsScreen (

                onBackPressed = {
                    navControlla.popBackStack()
                },
                cat = Json.decodeFromString(
                    it.arguments?.getString("cat")  ?: ""
                )
            )

        }

        composable ( Screens.FavoritePetsScreen.route ) {
            FavoritePetsScreen()
        }
    }


}