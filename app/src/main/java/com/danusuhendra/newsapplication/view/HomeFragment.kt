package com.danusuhendra.newsapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.danusuhendra.newsapplication.model.data.News
import com.danusuhendra.newsapplication.model.data.NewsData
import com.danusuhendra.newsapplication.R
import com.danusuhendra.newsapplication.adapter.NewsAdapter
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    private var carouselImage = intArrayOf(
        R.drawable.enam,
        R.drawable.tujuh,
        R.drawable.sebelas,
        R.drawable.delapan,
        R.drawable.satu
    )

    private var list: ArrayList<News> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselView.setImageListener(imageListener)
        carouselView.pageCount = carouselImage.size

        list.addAll(NewsData.listData)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        val newsAdapter =
            NewsAdapter(list)
        recyclerView.adapter = newsAdapter

        newsAdapter.setOnItemClickCallback(object : NewsAdapter.OnClickCallback {
            override fun onItemClicked(data: News) {
                showSelectedNews(data)
            }

        })
    }

    private var imageListener: ImageListener =
        ImageListener { position, imageView ->
            Picasso.get().load(carouselImage[position]).into(imageView)
        }

    private fun showSelectedNews(data: News) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("title", data.title)
        intent.putExtra("content", data.content)
        intent.putExtra("category", data.category)
        intent.putExtra("date", data.date)
        intent.putExtra("image", data.imgLarge)
        startActivity(intent)
    }

}

