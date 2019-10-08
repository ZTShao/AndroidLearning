package com.example.android.zhetai.androidlearning.Structure

import android.text.format.Time

data class ItemData(
    var avatarRes: Int,
    var accountName: String,
    var itemContentText: String,
    var logDate: Time
) {
    /*companion object {
        val AVATAR_RES = "AvatarRes"
        val ACCOUNT_NAME = "AccountName"
        val ITEM_CONTENT_TEXT = "ItemContentText"
    }

    fun toJSON(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put(AVATAR_RES, avatarRes)
        jsonObject.put(ACCOUNT_NAME, accountName)
        jsonObject.put(ITEM_CONTENT_TEXT, itemContentText)
        return jsonObject
    }*/
}
