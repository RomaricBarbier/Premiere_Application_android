package romaricbarbier.maformation.fr.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import romaricbarbier.maformation.fr.ui.model.DescFILM
import romaricbarbier.maformation.fr.ui.model.Film
import romaricbarbier.maformation.fr.ui.model.Persons
import romaricbarbier.maformation.fr.ui.model.Tv
import romaricbarbier.maformation.fr.ui.repository.Api

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build();

class MainViewModel : ViewModel() {

    val api = retrofit.create(Api::class.java)

    val listmovies = MutableStateFlow<List<Film>>(listOf())

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            listmovies.value =
                api.lastmovies(api_key = "82fb6ce9f6ac5a39cc14cab90876dffd").results
        }
    }
}

    class ViewModelserie : ViewModel() {

        val api = retrofit.create(Api::class.java)

        val listtvs = MutableStateFlow<List<Tv>>(listOf())

        init {
            getTvs()
        }

        fun getTvs() {
            viewModelScope.launch {
                listtvs.value =
                    api.lasttvs(api_key = "82fb6ce9f6ac5a39cc14cab90876dffd").results
            }
        }

}
class ViewModelperson : ViewModel() {

    val api = retrofit.create(Api::class.java)

    val listpersons = MutableStateFlow<List<Persons>>(listOf())

    init {
        getPersons()
    }

    fun getPersons() {
        viewModelScope.launch {
            listpersons.value =
                api.lastpersons(api_key = "82fb6ce9f6ac5a39cc14cab90876dffd").results
        }
    }
}


class ViewModeldescfilm (savedStateHandle: SavedStateHandle): ViewModel() {

    private val filmId : String = checkNotNull(savedStateHandle["filmId"])
    val api = retrofit.create(Api::class.java)

    val listDetailFilm = MutableStateFlow<DescFILM>(DescFILM())

    init {
        getDescFilm()
    }

    fun getDescFilm(){
        viewModelScope.launch {
             listDetailFilm.value = api.detailfilm(filmId, api_key = "24714091346b3079a0414fe486ba3858")
        }
    }
}