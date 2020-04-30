package com.danusuhendra.newsapplication.view.intropage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.danusuhendra.newsapplication.MainActivity
import com.danusuhendra.newsapplication.PrefHelper
import com.danusuhendra.newsapplication.R
import com.danusuhendra.newsapplication.adapter.AdapterViewPager
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    private lateinit var prefHelper: PrefHelper
    var indexIntro = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        prefHelper = PrefHelper(this)
        if (prefHelper.first) {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
        val adapter = AdapterViewPager(
            supportFragmentManager
        )
        view_pager.adapter = adapter
        dots_indicator.setViewPager(view_pager)

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                indexIntro = position
                Log.d("POSITION", indexIntro.toString())
                if (indexIntro == 2) {
                    btnNext.text = "GET STARTED"
                } else{
                    btnNext.text = "CONTINUE"
                }
            }
        })
        btnNext.setOnClickListener {
            if (indexIntro in 0..1) {
                view_pager.currentItem = indexIntro + 1
            } else if (indexIntro == 2) {
                prefHelper.first = true
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}
