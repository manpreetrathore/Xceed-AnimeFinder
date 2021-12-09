package com.example.android.herewego

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.Math.round

class MyAdapter(val context: Context, val userList: List<Result>): RecyclerView.Adapter<MyAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        lateinit var filename: TextView
        lateinit var episode: TextView
        lateinit var from:TextView
        lateinit var anilistId:TextView
        init {
            filename = itemView.findViewById(R.id.mainId)
            episode = itemView.findViewById(R.id.episode)
            from = itemView.findViewById(R.id.from)
            anilistId = itemView.findViewById(R.id.anilistid)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items,parent,false)
//        println("ItemView $itemView")

        itemView.post {
            itemView.layoutParams.height = parent.width/3
            itemView.requestLayout()
        }
        return ViewHolder(itemView)

//        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.filename.text = "Movie: "+userList[position].filename
//        holder.filename.setOnClickListener {(holder.filename.} // click event
        holder.episode.text = "Episode: "+userList[position].episode.toString()
        holder.from.text = "From: "+userList[position].from.toString()+"        To: "+userList[position].to.toString()
        holder.anilistId.text = "Anilist Id: "+userList[position].anilist.toString()+"        Similarity: "+ (round(userList[position].similarity * 1000.0) / 1000.0).toString()


        println("filename ${holder.filename}")
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}