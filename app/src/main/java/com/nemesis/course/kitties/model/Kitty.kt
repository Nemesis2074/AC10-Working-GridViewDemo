package com.nemesis.course.kitties.model

import com.google.gson.annotations.SerializedName

class Kitty {

    @SerializedName("id")
    var idKitty:Int = 0

    @SerializedName("photo")
    var photo:String = ""

}