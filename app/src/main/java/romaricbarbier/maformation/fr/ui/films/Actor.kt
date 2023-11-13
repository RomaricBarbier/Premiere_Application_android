package romaricbarbier.maformation.fr.ui.films

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import romaricbarbier.maformation.fr.R
import romaricbarbier.maformation.fr.ui.MainViewModel
import romaricbarbier.maformation.fr.ui.ViewModelperson
import romaricbarbier.maformation.fr.ui.theme.PremiereApplicationMonProfilTheme


@Composable
fun ScreenACTOR(windowSizeClass: WindowSizeClass){
    val classeHauteur = windowSizeClass.heightSizeClass
    val classeLargeur = windowSizeClass.widthSizeClass

    when (classeLargeur) {
        WindowWidthSizeClass.Compact -> {
            LayoutverticalActor(Modifier, windowSizeClass)
        }
        else -> {
            Row(Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically) {
                LayouthorizontalActor(Modifier, windowSizeClass)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutverticalActor(modifier: Modifier = Modifier,windowSizeClass: WindowSizeClass) {

    val ViewModel : ViewModelperson = viewModel()
    val films = ViewModel.listpersons.collectAsState()


    LazyVerticalGrid( columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(top = 70.dp)
            .border(
                BorderStroke(0.3.dp, Color.Black),
            )){

        items (films.value){ person ->
            Card {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    AsyncImage(
                        model = ("https://image.tmdb.org/t/p/w780/" + person.profile_path),
                        contentDescription = null,
                    )
                    Text(
                        text = person.name,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}


@Composable
fun LayouthorizontalActor(modifier: Modifier = Modifier,windowSizeClass: WindowSizeClass) {

    val ViewModel : ViewModelperson = viewModel()
    val films = ViewModel.listpersons.collectAsState()

    LazyVerticalGrid( columns = GridCells.Fixed(3),
        modifier = Modifier
            .padding(top = 70.dp)
            .border(
                BorderStroke(0.3.dp, Color.Black),
            )){
        items (films.value){ person ->
            Card {
                Column(verticalArrangement = Arrangement.Center
                ) {

                    AsyncImage(
                        model = ("https://image.tmdb.org/t/p/w780/" + person.profile_path),
                        contentDescription = null,
                        modifier = modifier
                            .size(200.dp)
                    )
                    Text(
                        text = person.name,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,)
                    }
            }

        }
    }
}