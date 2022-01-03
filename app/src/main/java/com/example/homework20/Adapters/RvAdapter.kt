package com.example.homework20.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework20.InfoActivity
import com.example.homework20.Model.InFo
import com.example.homework20.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_rv.view.*

class RvAdapter(val context: Context, val list: ArrayList<String>) :
    RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(position: Int) {
            Picasso.get().load(list[position]).into(itemView.item_image)
            itemView.setOnClickListener {
                context.startActivity(Intent(context, InfoActivity::class.java))
                InFo.imageInfo = list[position]
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))
    }

    override fun onBindViewHolder(holder: RvAdapter.Vh, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = list.size
}