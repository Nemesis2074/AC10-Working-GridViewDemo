package com.nemesis.course.kitties

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.nemesis.course.kitties.model.ConnectionManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ConnectionManager.loadKitties(success = { kitties ->

            for(kitty in kitties){
                Log.d("KITTY", kitty.photo)
                Toast.makeText(this, kitty.photo, Toast.LENGTH_SHORT).show()
            }



        }, fail = {

        })

    }
}
