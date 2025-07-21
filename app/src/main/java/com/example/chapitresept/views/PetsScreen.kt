package com.example.chapitresept.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.chapitresept.data.Cat
import com.example.chapitresept.navigation.ContentType
import com.example.chapitresept.viewmodel.PetsViewModel
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.getValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetsScreen (
    onPetClicked : (Cat) -> Unit,
    contentType : ContentType,
) {

   /*Scaffold (

       topBar= {

           TopAppBar (

               title = {
                   Text (
                       text = "Pets"
                   )
               } ,
               colors = TopAppBarDefaults.smallTopAppBarColors(
                   containerColor = MaterialTheme.colorScheme.primary
               )
           )
       } ,
       content = { paddingValues ->
           PetList (
               modifier = Modifier
                   .fillMaxSize()
                   .padding(paddingValues),
               onPetClicked = onPetClicked
           )

       }

   )
*/


    val petsViewModel : PetsViewModel = koinViewModel()
    val petsUIState by petsViewModel.petsUIState.collectAsStateWithLifecycle()

    PetsScreenContent (
        modifier = Modifier
            .fillMaxSize(),
        onPetClicked=onPetClicked,
        contentType = contentType,
        petsUIState = petsUIState

    )


}