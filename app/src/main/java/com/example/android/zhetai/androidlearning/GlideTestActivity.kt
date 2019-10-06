package com.example.android.zhetai.androidlearning

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.zhetai.androidlearning.Structure.ItemData
import com.example.android.zhetai.androidlearning.Widget.RecyclerViewWidgetListAdapter

class GlideTestActivity : Activity() {

    private lateinit var recyclerView: RecyclerView
    private val listData: MutableList<ItemData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide_test)
        recyclerView = findViewById(R.id.recyclerView_test)
        val itemData1 = ItemData(R.drawable.ic_boy_avatar, "邵帅哥", R.drawable.ic_girl_avatar, "我喜欢这个妹子")
        listData.add(itemData1)
        val itemData2 = ItemData(R.drawable.ic_girl_avatar, "11姐姐", R.drawable.ic_boy_avatar, "我也喜欢他")
        listData.add(itemData2)
        val itemData3 = ItemData(R.drawable.image_reb_head, "瑞白", R.drawable.ic_girl_avatar, "我喜欢小妈")
        listData.add(itemData3)
        val adapter = RecyclerViewWidgetListAdapter(this, listData)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


}
