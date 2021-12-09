package com.example.android.herewego

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//const val url = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Anime_Girl.svg/220px-Anime_Girl.svg.png"
//const val url = "https://i.pinimg.com/736x/76/53/cd/7653cd251de2ab3f95193dfcf9b2a01b.jpg"
interface ApiInterface {

//    @GET("search?url=https://i.pinimg.com/736x/76/53/cd/7653cd251de2ab3f95193dfcf9b2a01b.jpg")
//    ?url=https%3A%2F%2Fcdn.vox-cdn.com%2Fthumbor%2FHyOhm280EOQO2ubcOZCSONkDGb8%3D%2F0x0%3A1200x675%2F1200x800%2Ffilters%3Afocal(504x242%3A696x434)%2Fcdn.vox-cdn.com%2Fuploads%2Fchorus_image%2Fimage%2F68567666%2FDr._STONE_Season_2_release_date_Episode_24_ending_with_Stone_Wars_Dr._STONE_manga_compared_to_the_anime_Spoilers.0.jpg
    @GET("search?")
    fun getData(@Query("url",encoded = true) url:String):Call<MyData>
}