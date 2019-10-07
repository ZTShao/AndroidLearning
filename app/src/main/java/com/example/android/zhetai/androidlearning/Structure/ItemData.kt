package com.example.android.zhetai.androidlearning.Structure

import org.json.JSONObject

data class ItemData(
    var avatarRes: Int,
    var accountName: String,
    var itemContentImgRes: Int,
    var itemContentText: String
) {
    companion object {
        val AVATAR_RES = "AvatarRes"
        val ACCOUNT_NAME = "AccountName"
        val ITEM_CONTENT_IMG_RES = "ItemContentImgRes"
        val ITEM_CONTENT_TEXT = "ItemContentText"

        fun generateItemDataFromJSON(jsonObject: JSONObject): ItemData {
            val avatarRes = jsonObject.getInt(AVATAR_RES)
            val accountName = jsonObject.getString(ACCOUNT_NAME)
            val itemContentImgRes = jsonObject.getInt(ITEM_CONTENT_IMG_RES)
            val itemContentText = jsonObject.getString(ITEM_CONTENT_TEXT)
            return ItemData(avatarRes, accountName, itemContentImgRes, itemContentText)
        }
    }

    fun toJSON(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put(AVATAR_RES, avatarRes)
        jsonObject.put(ACCOUNT_NAME, accountName)
        jsonObject.put(ITEM_CONTENT_IMG_RES, itemContentImgRes)
        jsonObject.put(ITEM_CONTENT_TEXT, itemContentText)
        return jsonObject
    }
}
