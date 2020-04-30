package com.danusuhendra.newsapplication.model.data

import com.danusuhendra.newsapplication.R

object CategoryData {
    private val newsCategoryList = arrayOf(
        "Bola",
        "Pendidikan",
        "Hardware",
        "Game",
        "Internet",
        "Gaya Hidup",
        "Gadget",
        "E-Business",
        "Berita Nasional"
    )

    private val imageCategory = arrayOf(
        R.drawable.bola,
        R.drawable.education,
        R.drawable.hardware,
        R.drawable.game,
        R.drawable.internet,
        R.drawable.lifestyle,
        R.drawable.gadget,
        R.drawable.ebussines,
        R.drawable.news
    )

    val listData: ArrayList<Category>
        get() {
            val list = arrayListOf<Category>()
            for (position in newsCategoryList.indices) {
                val category = Category()
                category.categorylist = newsCategoryList[position]
                category.imgCategory = imageCategory[position]
                list.add(category)
            }
            return list
        }
}