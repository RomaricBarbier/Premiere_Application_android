package romaricbarbier.maformation.fr.ui.films

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import romaricbarbier.maformation.fr.ui.MainViewModel
import romaricbarbier.maformation.fr.ui.ViewModeldescfilm



@Composable
fun ScreenDescFILM(windowSizeClass: WindowSizeClass){
    val classeHauteur = windowSizeClass.heightSizeClass
    val classeLargeur = windowSizeClass.widthSizeClass

    when (classeLargeur) {
        WindowWidthSizeClass.Compact -> {
            LayoutverticalDescFilm(Modifier, windowSizeClass)
        }
        else -> {
            Row(Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically) {
                LayouthorizontalDescFilm(Modifier, windowSizeClass)
            }
        }
    }
}

@Composable
fun LayoutverticalDescFilm(modifier: Modifier = Modifier, windowSizeClass : WindowSizeClass){
    val ViewModel : ViewModeldescfilm = viewModel()
    val detailsfilm = ViewModel.listDetailFilm.collectAsState()

Log.v("ttt", "oui")
        AsyncImage(
            model = ("https://image.tmdb.org/t/p/w780/" + detailsfilm.value.poster_path),
            contentDescription = null,
            )
}


@Composable
fun LayouthorizontalDescFilm(modifier: Modifier = Modifier,windowSizeClass : WindowSizeClass) {

    val ViewModel : ViewModeldescfilm = viewModel()
    val detailsfilm = ViewModel.listDetailFilm.collectAsState().value;

    Log.v("ttt", "oui")
    AsyncImage(
        model = ("https://image.tmdb.org/t/p/w780/" + detailsfilm.poster_path),
        contentDescription = null,
    )
}
