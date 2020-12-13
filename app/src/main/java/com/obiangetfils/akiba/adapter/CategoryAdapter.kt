package com.obiangetfils.akiba.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.obiangetfils.akiba.R
import com.obiangetfils.akiba.model.Category
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryAdapter(val categoryList: Array<Category>, val listener: (Category) -> Unit) :
    Adapter<CategoryAdapter.CategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {

        // Création d'une View representant un élément de la liste
        val categoryView =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)

        // transformation de la View en CategoryHolder
        return CategoryHolder(categoryView)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(categoryList[position], listener)
    }

    override fun getItemCount(): Int = categoryList.size


    class CategoryHolder(val categoryItem: View) : RecyclerView.ViewHolder(categoryItem) {

        // Charger les éléments du RecyclerView
        fun bind(category: Category, listener: (Category) -> Unit) =
            with(itemView) {
                itemView.category_name.text = category.categoryName
                itemView.category_image.setImageResource(category.categoryImage)
                setOnClickListener { listener(category) }
            }
    }
}