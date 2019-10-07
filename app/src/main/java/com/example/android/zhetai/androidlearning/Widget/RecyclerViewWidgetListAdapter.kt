package com.example.android.zhetai.androidlearning.Widget

import android.content.Context
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.zhetai.androidlearning.R
import com.example.android.zhetai.androidlearning.Structure.ItemData

class RecyclerViewWidgetListAdapter(
    val context: Context?,
    var dataList: MutableList<ItemData>
) : RecyclerView.Adapter<RecyclerViewWidgetListAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(inflate(context, R.layout.item_itemview_glide_test_recyclerview, null))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.initContent(dataList[position])
        Glide.with(context!!).load("https://ztshao.github.io/zhetais.homepage/img/5.e357f3f7.jpeg").into(holder.itemContentImageView)
        holder.itemDeleteButton.setOnClickListener {
            dataList.removeAt(position)
            this.notifyItemRemoved(position)
            this.updateIndex(position)
        }
    }

    private fun updateIndex(position: Int) {
        this.notifyItemRangeChanged(position, itemCount - position)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemContentImageView: ImageView = itemView.findViewById(R.id.image_view_content)
        var itemAvatarImageView: ImageView = itemView.findViewById(R.id.image_view_avatar)
        var itemAccountTextView: TextView = itemView.findViewById(R.id.text_view_account_name)
        var itemDeleteButton: ImageView = itemView.findViewById(R.id.button_delete_item)
        var itemContentTextView: TextView = itemView.findViewById(R.id.text_view_content)

        fun initContent(itemData: ItemData) {
            itemAvatarImageView.setImageResource(itemData.avatarRes)
            itemAccountTextView.text = itemData.accountName
            itemContentTextView.text = itemData.itemContentText
        }
    }
}