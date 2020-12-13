package com.obiangetfils.akiba.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.obiangetfils.akiba.R
import com.obiangetfils.akiba.model.HandyMan
import kotlinx.android.synthetic.main.view_all_handyman.*
import kotlinx.android.synthetic.main.view_all_handyman.view.*

class AllHandymanAdapter(val handyManList: Array<HandyMan>, val listener: (HandyMan) -> Unit) :
    RecyclerView.Adapter<AllHandymanAdapter.AllHandyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllHandyHolder {

        // Création d'une View representant un élément de la liste
        val allHandyManView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_all_handyman, parent, false)

        // transformation de la View en CategoryHolder
        return AllHandyHolder(allHandyManView)
    }

    override fun onBindViewHolder(holder: AllHandyHolder, position: Int) {
        holder.bindAllHandyMan(handyManList[position], listener)
    }

    override fun getItemCount(): Int = handyManList.size

    class AllHandyHolder(val handyManItem: View): RecyclerView.ViewHolder(handyManItem) {

        // Charger les éléments du RecyclerView
        fun bindAllHandyMan(handyMan: HandyMan, listener: (HandyMan) -> Unit) =
            with(itemView) {

                itemView.artisan_id.setImageResource(handyMan.handyManImage)
                itemView.all_name_and_firstname.text = "${handyMan.handyManFirstName} ${handyMan.handyManName}"

                itemView.all_rate.rating = handyMan.handyManNote
                itemView.all_rate.numStars = 5

                itemView.all_price.text = "${handyMan.handyManServicePrice} Fcfa"

                setOnClickListener { listener(handyMan) }
            }
    }
}