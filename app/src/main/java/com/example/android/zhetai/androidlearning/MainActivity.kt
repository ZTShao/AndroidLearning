package com.example.android.zhetai.androidlearning

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : Activity() {

    private lateinit var networkTestButton: Button
    private lateinit var jsonTestButton: Button
    private lateinit var sqliteTestButton: Button
    private lateinit var glideTestButton: Button

    private lateinit var imageView1: ImageView
    private lateinit var imageView2: ImageView
    private lateinit var imageView3: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        networkTestButton = findViewById(R.id.button_webview_test)
        networkTestButton.setOnClickListener {
            startActivity(Intent(this, NetworkTestActivity::class.java))
        }

        jsonTestButton = findViewById(R.id.button_json_test)
        jsonTestButton.setOnClickListener {
            startActivity(Intent(this, JsonTestActivity::class.java))
        }

        glideTestButton = findViewById(R.id.button_glide_test)
        glideTestButton.setOnClickListener {

        }

        sqliteTestButton = findViewById(R.id.button_sqlite_test)
        sqliteTestButton.setOnClickListener {
            startActivity(Intent(this, SQLiteDBTestActivity::class.java))
        }

        imageView1 = findViewById(R.id.imageview_pic1)
        imageView1.setImageResource(R.drawable.image_reb_head)
        imageView2 = findViewById(R.id.imageview_pic2)
        imageView2.setImageResource(R.drawable.image_reb_body)
        imageView3 = findViewById(R.id.imageview_pic3)
        imageView3.setImageResource(R.drawable.image_reb_foot)
    }
}
