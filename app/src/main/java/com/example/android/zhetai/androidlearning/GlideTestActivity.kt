package com.example.android.zhetai.androidlearning

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.zhetai.androidlearning.Structure.ItemData
import com.example.android.zhetai.androidlearning.Widget.RecyclerViewWidgetListAdapter

class GlideTestActivity : Activity() {

    private lateinit var recyclerView: RecyclerView
    private val listData: MutableList<ItemData> = ArrayList()
    private lateinit var loadImageButton: Button
    private lateinit var glideImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide_test)
        recyclerView = findViewById(R.id.recyclerView_test)
        loadImageButton = findViewById(R.id.button_load_image)
        glideImage = findViewById(R.id.image_view_glide_resource)
        val itemData1 = ItemData(R.drawable.ic_boy_avatar, "邵帅哥", R.drawable.ic_girl_avatar, "我喜欢这个妹子")
        listData.add(itemData1)
        val itemData2 = ItemData(R.drawable.ic_girl_avatar, "11姐姐", R.drawable.ic_boy_avatar, "我也喜欢他")
        listData.add(itemData2)
        val itemData3 = ItemData(R.drawable.image_reb_head, "瑞白", R.drawable.ic_girl_avatar, "我喜欢小妈")
        listData.add(itemData3)
        val adapter = RecyclerViewWidgetListAdapter(this, listData)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        loadImageButton.setOnClickListener {
            Glide.with(this)
                .load("https://ztshao.github.io/zhetais.homepage/img/love.a5796752.jpg")
                .into(glideImage)
        }
    }


}
