package com.example.chapitresept.views


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.chapitresept.data.Cat


@OptIn(ExperimentalMaterial3Api :: class, ExperimentalLayoutApi::class)
@Composable
fun PetListItem (cat: Cat ,
                 onPetClicked : (Cat) -> Unit
                 ) {

    ElevatedCard (
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {

        Column (

            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .clickable{
                    onPetClicked(cat)
                }
        ) {

            AsyncImage (
                model = // "https://cataas.com/cat/${cat.id}"
                    "https://cataas.com/cat/${cat.tags.firstOrNull() ?: "cute"}"
                // ou on pouvait utiliser ca:  model = "https://cataas.com/cat/cute/says/Hello"
                ,
                contentDescription = "Cute cat",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.FillWidth
            )

            FlowRow (
                modifier = Modifier
                    .padding(start = 6.dp , end = 6.dp)
            ) {

                repeat(cat.tags.size) {
                    SuggestionChip (
                        modifier = Modifier
                            .padding(start= 3.dp,end = 3.dp) ,
                        onClick = {  },
                        label = {
                            Text (
                                text = cat.tags[it]
                            )
                        }
                    )


                }

            }

        }

    }

}