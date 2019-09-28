package com.nemesis.course.kitties.model

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConnectionManager {

    companion object{

        private val BASE_URL = "https://mi-docencia-benv.web.app"

        //Configuración RETROFIT
        private fun create(): KittiesServices{

            //Configura GSON
            val gson = GsonBuilder().create()

            //Configura Retrofit
            val retrofitBuilder = Retrofit.Builder()
            retrofitBuilder.baseUrl(BASE_URL)
            retrofitBuilder.addConverterFactory(GsonConverterFactory.create(gson))

            val retrofit = retrofitBuilder.build()
            return retrofit.create(KittiesServices::class.java)
        }

        fun loadKitties(success: (kitties: ArrayList<Kitty>) -> Unit, fail: (error: String) -> Unit){

            val call = ConnectionManager.create().loadKitties()
            call.enqueue(object : Callback<ArrayList<Kitty>>{

                override fun onFailure(call: Call<ArrayList<Kitty>>, t: Throwable) {
                    fail("Error al leer los datos")
                }

                override fun onResponse(call: Call<ArrayList<Kitty>>, response: Response<ArrayList<Kitty>>) {
                    val array = response.body()
                    if(array != null){
                        success(array)
                    }else{
                        fail("No hay gatitos")
                    }
                }


            })

        }

    }

}