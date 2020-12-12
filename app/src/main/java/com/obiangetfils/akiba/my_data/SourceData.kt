package com.obiangetfils.akiba.my_data

import com.obiangetfils.akiba.R

abstract class SourceData {

    companion object {

        /** SliderView **/
        val slideMap: MutableMap<String, Int> = mutableMapOf(
            "Plombier" to R.drawable.ic_plombier,
            "Menuisier" to R.drawable.ic_menuisier,
            "Maçon" to R.drawable.ic_macon
        )

        /** Categorie **/
        val categoryMap: MutableMap<String, Int> = mutableMapOf(
            "Plombier" to R.drawable.ic_plombier,
            "Menuisier" to R.drawable.ic_menuisier,
            "Maçon" to R.drawable.ic_macon,
            "Chauffeur" to R.drawable.ic_chauffeur,
            "Coiffeur" to R.drawable.ic_coiffeur,
            "Charpentier" to R.drawable.ic_charpentier,
            "Femme de menage" to  R.drawable.ic_femme_menage
        )

    }

}