package com.nemesis.course.kitties.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.nemesis.course.kitties.R
import com.nemesis.course.kitties.model.Kitty
import com.squareup.picasso.Picasso

class KittiesAdapter(context:Context, resId:Int, kitties:ArrayList<Kitty>):
    ArrayAdapter<Kitty>(context, resId, kitties) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView;
        if(view == null){

            val inflater = LayoutInflater.from(parent.context)
            view = inflater.inflate(R.layout.item_kitty, parent, false)
        }

        val kitty = getItem(position)

        if(view != null && kitty != null) {

            val imgPhoto: ImageView = view.findViewById(R.id.kitty_photo)

            Picasso.get().load(kitty.photo).into(imgPhoto)

        }

        return view!!

    }


}