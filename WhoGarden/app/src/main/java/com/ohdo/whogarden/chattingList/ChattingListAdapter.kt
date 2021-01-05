package com.ohdo.whogarden.chattingList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ohdo.whogarden.R

class ChattingListAdapter : RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<ChattingListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chatting_list, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = listData[position]
        holder.setListData(data)
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val profileImage = itemView.findViewById<ImageView>(R.id.item_profile_img)
    private val userName = itemView.findViewById<TextView>(R.id.item_nickname)
    private val lastMsg = itemView.findViewById<TextView>(R.id.item_message)
    private val lastTime = itemView.findViewById<TextView>(R.id.item_time)

    fun setListData(listData: ChattingListData) {
        profileImage.setImageDrawable(listData.profileImg)
        userName.text = listData.userName
        lastMsg.text = listData.lastMessage
        lastTime.text = listData.lastTime
    }

}