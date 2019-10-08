package com.example.android.zhetai.androidlearning

import android.app.Activity
import android.os.Bundle
import android.text.format.Time
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.zhetai.androidlearning.Structure.ItemData
import com.example.android.zhetai.androidlearning.Utils.DataManager
import com.example.android.zhetai.androidlearning.Widget.RecyclerViewWidgetListAdapter
import com.google.gson.GsonBuilder
import java.util.*

internal class JsonTestActivity : Activity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addLogButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var logEditText: EditText
    private lateinit var adapter: RecyclerViewWidgetListAdapter
    private val logDataManager = DataManager(this, LOG_FILE_NAME, GsonBuilder().create())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_test)

        addLogButton = findViewById(R.id.button_add_log)
        nameEditText = findViewById(R.id.edit_text_name)
        logEditText = findViewById(R.id.edit_text_log)
        recyclerView = findViewById(R.id.recyclerView_test)

        recyclerView.layoutManager = LinearLayoutManager(this)
        addLogButton.setOnClickListener {
            val time = Time()
            time.setToNow()
            val item = ItemData(DEFAULT_AVARTAR_RES,
                if(nameEditText.text.toString() == "") DEFAULT_NAME else nameEditText.text.toString(),
                logEditText.text.toString(),
                time)

            adapter.addItem(item)
            nameEditText.setText("", TextView.BufferType.EDITABLE)
            logEditText.setText("", TextView.BufferType.EDITABLE)
        }
    }

    override fun onStart() {
        super.onStart()
        adapter = RecyclerViewWidgetListAdapter(this, logDataManager.loadFromFile())
        recyclerView.adapter = adapter
    }

    override fun onStop() {
        super.onStop()
        val curList = adapter.dataList
        logDataManager.saveListToFile(curList)
    }

    companion object {
        private const val DEFAULT_AVARTAR_RES = R.drawable.ic_boy_avatar
        private const val LOG_FILE_NAME = "logFile.json"
        private const val DEFAULT_NAME = "邵小皮"
    }
}
