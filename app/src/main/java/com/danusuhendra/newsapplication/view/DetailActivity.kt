package com.danusuhendra.newsapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danusuhendra.newsapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        toolbar.title = intent.getStringExtra("title")
        tvTitle.text = intent.getStringExtra("title")
        tvCategory.text = intent.getStringExtra("category")
        tvContent.text = intent.getStringExtra("content")
        tvDate.text = intent.getStringExtra("date")
        Picasso.get().load(intent.getIntExtra("image", 0)).into(imgDetail)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
