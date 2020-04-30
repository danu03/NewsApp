package com.danusuhendra.newsapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danusuhendra.newsapplication.model.data.News
import com.danusuhendra.newsapplication.R

class NewsAdapter(private val listNews : ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.ListViewHolder>() {
    private lateinit var onClickCallback: OnClickCallback

    fun setOnItemClickCallback(onClickCallback: OnClickCallback) {
        this.onClickCallback = onClickCallback
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_news, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val news = listNews[position]

        holder.tvTitle.text = news.title
        holder.tvCategory.text = news.category
        holder.tvDate.text = news.date
        holder.imgNews.setImageResource(news.imgLarge)

        holder.itemView.setOnClickListener {
            onClickCallback.onItemClicked(listNews[holder.adapterPosition])
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle  = itemView.findViewById<TextView>(R.id.tvItemTitle)
        var tvCategory  = itemView.findViewById<TextView>(R.id.tvItemCategory)
        var tvDate  = itemView.findViewById<TextView>(R.id.tvItemDate)
        var imgNews  = itemView.findViewById<ImageView>(R.id.img_item_news)

    }

    interface OnClickCallback {
        fun onItemClicked(data: News)
    }
}