package com.nemesis.course.kitties.model

import retrofit2.Call
import retrofit2.http.GET

interface KittiesServices {

    @GET("/demos/kitties.json")
    fun loadKitties(): Call< ArrayList<Kitty> >

}