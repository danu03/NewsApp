package com.danusuhendra.newsapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.danusuhendra.newsapplication.view.HomeFragment
import com.danusuhendra.newsapplication.view.ProfileFragment
import com.danusuhendra.newsapplication.view.CategoryFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    companion object{
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Intent().apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        navigateFragment(HomeFragment())
        newsToolbar.title = "Home"
        newsToolbar.setTitleTextColor(Color.WHITE)
        bottomNavMenu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {
                    Log.d(TAG,"navigation home")
                    navigateFragment(HomeFragment())
                    newsToolbar.title = "Home"
                }
                R.id.nav_profile -> {
                    Log.d(TAG,"navigation profile")
                    navigateFragment(ProfileFragment())
                    newsToolbar.title = "Profile"
                }
                R.id.nav_category -> {
                    Log.d(TAG,"navigation category")
                    navigateFragment(CategoryFragment())
                    newsToolbar.title = "Category"
                }
            }
            true
        }

    }

    private fun navigateFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragment, fragment)
                commit()
            }
    }


}
