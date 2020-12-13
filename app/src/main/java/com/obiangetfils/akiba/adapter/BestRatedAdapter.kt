package com.obiangetfils.akiba.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.obiangetfils.akiba.R
import com.obiangetfils.akiba.model.HandyMan
import kotlinx.android.synthetic.main.best_rated.view.*

class BestRatedAdapter(val handyManList: Array<HandyMan>, val listener: (HandyMan) -> Unit) :
    RecyclerView.Adapter<BestRatedAdapter.BestRatedHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestRatedHolder {

        // Création d'une View representant un élément de la liste
        val bestRatedView =
            LayoutInflater.from(parent.context).inflate(R.layout.best_rated, parent, false)

        // transformation de la View en CategoryHolder
        return BestRatedHolder(bestRatedView)

    }

    override fun onBindViewHolder(holder: BestRatedHolder, position: Int) {
        holder.bindHandyMan(handyManList[position], listener)
    }

    override fun getItemCount(): Int = handyManList.size

    class BestRatedHolder(val handyManItem: View): RecyclerView.ViewHolder(handyManItem) {

        // Charger les éléments du RecyclerView
        fun bindHandyMan(handyMan: HandyMan, listener: (HandyMan) -> Unit) =
            with(itemView) {

                itemView.best_rated_artisan_id.setImageResource(handyMan.handyManImage)
                itemView.best_rated_firstname_and_name.text = "${handyMan.handyManFirstName} ${handyMan.handyManName}"

                itemView.best_rated_rate.rating = handyMan.handyManNote
                itemView.best_rated_rate.setNumStars(5)

                itemView.best_rated_price_unit.text = "${handyMan.handyManServicePrice} Fcfa"

                setOnClickListener { listener(handyMan) }
            }

    }

}