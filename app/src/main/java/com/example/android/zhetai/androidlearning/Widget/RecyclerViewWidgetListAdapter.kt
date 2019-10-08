package com.example.android.zhetai.androidlearning.Widget

import android.content.Context
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.zhetai.androidlearning.KotlinExtensions.getString
import com.example.android.zhetai.androidlearning.R
import com.example.android.zhetai.androidlearning.Structure.ItemData

class RecyclerViewWidgetListAdapter(
    val context: Context?,
    var dataList: ArrayList<ItemData>
) : RecyclerView.Adapter<RecyclerViewWidgetListAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(inflate(context, R.layout.item_itemview_glide_test_recyclerview, null))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int, payloads: MutableList<Any>) {
        holder.itemDeleteButton.setOnClickListener {
            deleteItem(position)
        }
        if (payloads.isNotEmpty() && payloads[0] == PayLoadType.CHANGE) return
        holder.initContent(dataList[position])
    }

    private fun updateIndex(position: Int) {
        notifyItemRangeChanged(position, itemCount - position, PayLoadType.CHANGE)
    }

    public fun addItem(item: ItemData) {
        dataList.add(item)
        notifyItemInserted(dataList.size)
    }

    public fun deleteItem(position: Int) {
        dataList.removeAt(position)
        notifyItemRemoved(position)
        updateIndex(position)
    }

    enum class PayLoadType {
        INIT,
        CHANGE
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemAvatarImageView: ImageView = itemView.findViewById(R.id.image_view_avatar)
        var itemAccountTextView: TextView = itemView.findViewById(R.id.text_view_account_name)
        var itemDeleteButton: ImageView = itemView.findViewById(R.id.button_delete_item)
        var itemContentTextView: TextView = itemView.findViewById(R.id.text_view_content)
        var itemDateTextView: TextView = itemView.findViewById(R.id.text_view_log_date)

        fun initContent(itemData: ItemData) {
            itemAvatarImageView.setImageResource(itemData.avatarRes)
            itemAccountTextView.text = itemData.accountName
            itemContentTextView.text = itemData.itemContentText
            itemDateTextView.text = String.format(
                itemDateTextView.getString(R.string.date_format),
                itemData.logDate.month + 1,
                itemData.logDate.monthDay,
                itemData.logDate.hour,
                itemData.logDate.minute
            )
        }
    }
}