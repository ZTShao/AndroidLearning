package com.example.android.zhetai.androidlearning

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideTestActivity : Activity() {
    private lateinit var loadImageButton: Button
    private lateinit var glideImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide_test)
        loadImageButton = findViewById(R.id.button_load_image)
        glideImage = findViewById(R.id.image_view_glide_resource)
        loadImageButton.setOnClickListener {
            Glide.with(this)
                .load("https://ztshao.github.io/zhetais.homepage/img/love.a5796752.jpg")
                .into(glideImage)
        }
    }
}
