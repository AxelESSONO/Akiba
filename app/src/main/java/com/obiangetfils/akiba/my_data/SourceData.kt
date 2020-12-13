package com.obiangetfils.akiba.my_data

import com.obiangetfils.akiba.R
import com.obiangetfils.akiba.model.Category
import com.obiangetfils.akiba.model.HandyMan

abstract class SourceData {

    companion object {

        /** SliderView **/
        val slideMap: MutableMap<String, Int> = mutableMapOf(
            "Plombier" to R.drawable.ic_plombier,
            "Menuisier" to R.drawable.ic_menuisier,
            "Maçon" to R.drawable.ic_macon
        )

        /** Categorie **/
        val categoryMap = mutableListOf<Category>(
            Category("Plombier", R.drawable.ic_plombier),
            Category("Menuisier", R.drawable.ic_menuisier),
            Category("Maçon", R.drawable.ic_macon),
            Category("Chauffeur", R.drawable.ic_chauffeur),
            Category("Coiffeur", R.drawable.ic_coiffeur),
            Category("Charpentier", R.drawable.ic_charpentier),
            Category("Femme de menage", R.drawable.ic_femme_menage)
        )

        /** Best Rated **/
        val handyManList = mutableListOf<HandyMan>(
            HandyMan(1, "ESSONO", "Axel", 70_000, "Plombier", R.drawable.ic_plombier, R.string.description_example.toString(), 1.0f),
            HandyMan(2, "NDZEVILA", "Orphé", 800_000, "Menuisier", R.drawable.ic_menuisier, R.string.description_example.toString(), 1.0f),
            HandyMan(3, "ENGONGA", "Franck", 6_000_000, "Maçon", R.drawable.ic_macon, R.string.description_example.toString(), 4.9f),
            HandyMan(4, "MBOUROU", "Gael", 1_200_000, "Chauffeur", R.drawable.ic_chauffeur, R.string.description_example.toString(), 3.5f),
            HandyMan(5, "AYINGONE", "Sakina", 330_000, "Coiffeur", R.drawable.ic_coiffeur, R.string.description_example.toString(), 2.9f),
            HandyMan(6, "ASSOUMOU", "Keran", 405_000, "Charpentier", R.drawable.ic_charpentier, R.string.description_example.toString(), 2.9f),
            HandyMan(7, "NZE", "Noel", 12_562_000, "Femme de menage", R.drawable.ic_femme_menage, R.string.description_example.toString(), 3.9f)
        )

    }

}