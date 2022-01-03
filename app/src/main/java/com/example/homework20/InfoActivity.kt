package com.example.homework20

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.homework20.Model.InFo
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.dialog_item.view.*
import java.io.IOException


class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        supportActionBar?.hide()

        Picasso.get().load(InFo.imageInfo).into(info_image)

        btn_backspace.setOnClickListener {
            finish()
        }
        btn_about.setOnClickListener {
            val alertDialog = BottomSheetDialog(this, R.style.SheetDialog)
            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_item, null, false)
            alertDialog.setContentView(dialogView)
            alertDialog.setCancelable(true)
            alertDialog.show()
        }
        btn_set_wallpaper.setOnClickListener {
            var result: Bitmap? = null
            try {
                result = Picasso.get().load(InFo.imageInfo).get()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            val wallpaperManager = WallpaperManager.getInstance(applicationContext)
            try {
                wallpaperManager.setBitmap(result)
            } catch (ex: IOException) {
                ex.printStackTrace()
            }
        }


    }
}