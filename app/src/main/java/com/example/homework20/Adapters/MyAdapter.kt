package com.example.homework20.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.homework20.R
import kotlinx.android.synthetic.main.item_vp.view.*

class MyAdapter(val list: ArrayList<ArrayList<String>>, var context: Context) : PagerAdapter() {
    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
                LayoutInflater.from(container.context).inflate(R.layout.item_vp, container, false)

        layoutInflater.rv.adapter = RvAdapter(context, list[position])
        container.addView(layoutInflater)
        return layoutInflater
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}
//interface RvClick{
//    fun onClick(context: Context)
//}