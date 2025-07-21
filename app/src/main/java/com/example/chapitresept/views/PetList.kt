package com.example.chapitresept.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.lazy.items
import com.example.chapitresept.data.Cat
import com.example.chapitresept.viewmodel.PetsViewModel


@Composable
fun PetList(
            onPetClicked: (Cat) -> Unit ,
            pets : List<Cat>,
            modifier: Modifier) {
   /* val petsViewModel: PetsViewModel = koinViewModel()
    val petsUIState by petsViewModel.petsUIState.collectAsStateWithLifecycle()

    Column (
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility (
            visible = petsUIState.isLoading
        ) {
            CircularProgressIndicator()
        }

        AnimatedVisibility (
            visible = petsUIState.pets.isNotEmpty()
        )
         {
            LazyColumn (
                modifier = Modifier
            ) {
                items( petsUIState.pets  ) {

                        pet -> PetListItem(
                     cat = pet,
                     onPetClicked = onPetClicked
                            )
                }
            }
        }

        AnimatedVisibility (
            visible = petsUIState.error != null
        ) {
            Text (
                text = petsUIState.error  ?: ""
            )
        }



    }
*/

    LazyColumn (
        modifier = modifier
    ){

        items(pets) {

            pet ->
            PetListItem (
                cat = pet,
                onPetClicked = onPetClicked
            )
        }
    }

}