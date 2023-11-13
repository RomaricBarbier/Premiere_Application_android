package romaricbarbier.maformation.fr.ui.repository

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import romaricbarbier.maformation.fr.ui.model.DescFILM
import romaricbarbier.maformation.fr.ui.model.FilmsSemaineFR
import romaricbarbier.maformation.fr.ui.model.PersonSemaineFr
import romaricbarbier.maformation.fr.ui.model.TvSemaineFR

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): FilmsSemaineFR

    @GET("trending/tv/week")
    suspend fun lasttvs(@Query("api_key") api_key : String) : TvSemaineFR

    @GET("trending/person/week")
    suspend fun lastpersons(@Query("api_key") api_key : String) : PersonSemaineFr

    @GET("/movie/{filmId}")
    suspend fun detailfilm(@Path("filmId") filmId : String,@Query("api_key") api_key : String) : DescFILM
}


