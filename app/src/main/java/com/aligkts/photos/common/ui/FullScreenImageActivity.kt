package com.aligkts.photos.common.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aligkts.photos.R
import com.aligkts.photos.databinding.ActivityFullScreenImageBinding
import com.aligkts.photos.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_full_screen_image.*

class FullScreenImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_full_screen_image)
        intent?.let {
            val imageUri = intent.data
            if (imageUri != null) {
                Glide.with(this)
                    .load(imageUri)
                    .into(binding.imgFullScreen)
            }
        }
    }

}