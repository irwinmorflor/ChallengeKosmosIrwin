package com.example.challengekosmosirwin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.challengekosmosirwin.data.entity.ResultsAPI
import com.example.challengekosmosirwin.ui.viewModel.RickAndMortyViewModel

@Composable
fun Loader(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.0.dp)
                .padding(10.dp), color = Color.Black
        )
    }

}

@Composable
fun ListCharacters(characters: List<ResultsAPI>, navController: NavController, viewModel: RickAndMortyViewModel) {
    LazyColumn {
        items(characters) { item ->
            AsyncImage(model = item.image, contentDescription = item.name)
            NormalText(textString = item.name)
            Button(onClick = {
                viewModel.characterSelected = item
                navController.navigate("DETAIL/" + item.status) }) {
                Text("Detalle")
            }
        }
    }
}

@Composable
fun NormalText(textString: String?){
    Text(modifier = Modifier
        .fillMaxSize()
        .wrapContentHeight()
        .padding(8.dp),
        text = textString!!, style = TextStyle(fontSize = 18.sp))
}

