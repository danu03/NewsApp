package com.danusuhendra.newsapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danusuhendra.newsapplication.R
import com.danusuhendra.newsapplication.model.data.Category
import com.danusuhendra.newsapplication.model.data.News

class CategoryAdapter (private val listCategory : ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private lateinit var onClickCallback: OnClickCallback

    fun setOnItemClickCallback(onClickCallback: OnClickCallback) {
        this.onClickCallback = onClickCallback
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_category, viewGroup,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listCategory.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = listCategory[position]

        holder.tvCategory.text = category.categorylist
        holder.imgCategory.setImageResource(category.imgCategory)

        holder.itemView.setOnClickListener {
            onClickCallback.onItemClicked(listCategory[holder.adapterPosition])
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvCategory = itemView.findViewById<TextView>(R.id.tvCategory)
        var imgCategory = itemView.findViewById<ImageView>(R.id.imgCategory)
    }

    interface OnClickCallback {
        fun onItemClicked(data: Category)
    }
}