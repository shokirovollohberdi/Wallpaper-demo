package com.example.homework20


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework20.Adapters.MyAdapter
import com.example.homework20.Model.MyImageList
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_tab.view.*

class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.hide()


        open_navi.setOnClickListener {
            drawable_layout.openDrawer(Gravity.LEFT)
        }

        MyImageList.add()
        myAdapter = MyAdapter(MyImageList.list, this)

        view_pager.adapter = myAdapter

        tab.setupWithViewPager(view_pager)

        setTab()

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.tab_txt?.setTextColor(Color.WHITE)
                tab?.customView?.tab_image?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.tab_txt?.setTextColor(Color.GRAY)
                tab?.customView?.tab_image?.visibility = View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })



        soxta_bottom_nav_bar()

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_menu -> {
                    activity_name.text = "Home"
                    popular_nav_indic.visibility = View.INVISIBLE
                    liked_nar_bar_indic.visibility = View.INVISIBLE
                    random_nav_indic.visibility = View.INVISIBLE
                    home_nav_bar_idic.visibility = View.VISIBLE
                    drawable_layout.close()
                }

                R.id.popular_menu -> {
                    activity_name.text = "Popular"
                    popular_nav_indic.visibility = View.VISIBLE
                    liked_nar_bar_indic.visibility = View.INVISIBLE
                    random_nav_indic.visibility = View.INVISIBLE
                    home_nav_bar_idic.visibility = View.INVISIBLE
                    drawable_layout.close()
                }

                R.id.random_menu -> {
                    activity_name.text = "Random"
                    popular_nav_indic.visibility = View.INVISIBLE
                    liked_nar_bar_indic.visibility = View.INVISIBLE
                    random_nav_indic.visibility = View.VISIBLE
                    home_nav_bar_idic.visibility = View.INVISIBLE
                    activty_icon.setImageResource(R.drawable.random_nav_bar)
                    drawable_layout.close()
                }

                R.id.liked_menu -> {
                    activity_name.text = "Liked"
                    popular_nav_indic.visibility = View.INVISIBLE
                    liked_nar_bar_indic.visibility = View.VISIBLE
                    random_nav_indic.visibility = View.INVISIBLE
                    home_nav_bar_idic.visibility = View.INVISIBLE
                    drawable_layout.close()
                }

                R.id.history_menu -> {
                    // activity_name.text = "History"
//                    popular_nav_indic.visibility = View.INVISIBLE
//                    liked_nar_bar_indic.visibility = View.INVISIBLE
//                    random_nav_indic.visibility = View.INVISIBLE
//                    home_nav_bar_idic.visibility = View.VISIBLE
                    drawable_layout.close()
                }

                R.id.about_menu -> {
                    // activity_name.text = "About"
//                    popular_nav_indic.visibility = View.INVISIBLE
//                    liked_nar_bar_indic.visibility = View.INVISIBLE
//                    random_nav_indic.visibility = View.INVISIBLE
//                    home_nav_bar_idic.visibility = View.INVISIBLE
                    drawable_layout.close()
                }


            }
            true
        }

    }


    private fun soxta_bottom_nav_bar() {
        home_nav_bar.setOnClickListener {
            popular_nav_indic.visibility = View.INVISIBLE
            liked_nar_bar_indic.visibility = View.INVISIBLE
            random_nav_indic.visibility = View.INVISIBLE
            home_nav_bar_idic.visibility = View.VISIBLE
            activty_icon.setImageResource(R.drawable.ic_baseline_search_24)
            activity_name.text = "Home"

        }
        popular_nav_bar.setOnClickListener {
            popular_nav_indic.visibility = View.VISIBLE
            liked_nar_bar_indic.visibility = View.INVISIBLE
            random_nav_indic.visibility = View.INVISIBLE
            home_nav_bar_idic.visibility = View.INVISIBLE
            activty_icon.setImageResource(R.drawable.ic_baseline_search_24)
            activity_name.text = "Popular"
        }
        random_nav_bar.setOnClickListener {
            popular_nav_indic.visibility = View.INVISIBLE
            liked_nar_bar_indic.visibility = View.INVISIBLE
            random_nav_indic.visibility = View.VISIBLE
            home_nav_bar_idic.visibility = View.INVISIBLE
            activty_icon.setImageResource(R.drawable.random_nav_bar)
            activity_name.text = "Random"
        }
        liked_nav_bar.setOnClickListener {
            popular_nav_indic.visibility = View.INVISIBLE
            liked_nar_bar_indic.visibility = View.VISIBLE
            random_nav_indic.visibility = View.INVISIBLE
            home_nav_bar_idic.visibility = View.INVISIBLE
            activty_icon.setImageResource(android.R.color.transparent)
            activity_name.text = "Liked"
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun setTab() {
        val tabCount = tab.tabCount
        val tabList = arrayListOf<String>("All", "Animation", "Animals", "Technology", "Nature")
        for (i in 0 until tabCount) {
            val view = LayoutInflater.from(this).inflate(R.layout.item_tab, null, false)
            val tap = tab.getTabAt(i)
            tap?.customView = view
            view.tab_txt.text = tabList[i]
            if (i == 0) {
                view.tab_image.visibility = View.VISIBLE
                view.tab_txt.setTextColor(Color.WHITE)
            } else {
                view.tab_image.visibility = View.INVISIBLE
                view.tab_txt.setTextColor(Color.GRAY)
            }
        }
    }

}