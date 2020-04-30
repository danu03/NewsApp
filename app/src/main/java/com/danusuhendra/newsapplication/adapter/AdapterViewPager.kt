package com.danusuhendra.newsapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.danusuhendra.newsapplication.view.intropage.Intro1Fragment
import com.danusuhendra.newsapplication.view.intropage.Intro2Fragment
import com.danusuhendra.newsapplication.view.intropage.Intro3Fragment

class AdapterViewPager(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    private val fragment = listOf(
        Intro1Fragment(),
        Intro2Fragment(),
        Intro3Fragment()
    )

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

    override fun getCount(): Int {
        return fragment.size
    }
}