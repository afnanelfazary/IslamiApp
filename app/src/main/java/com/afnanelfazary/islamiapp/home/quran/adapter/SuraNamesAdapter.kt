package com.afnanelfazary.islamiapp.home.quran.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.afnanelfazary.islamiapp.R

class SuraNamesAdapter(val suraitems: List<String>, val aiatitems: List<String>) :
    RecyclerView.Adapter<SuraNamesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sura_name, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val suraName = suraitems.get(position)
        holder.suraName.setText(suraName)
        val aiatNumber = aiatitems.get(position)
        holder.aiatNumber.setText(aiatNumber)
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, suraName, aiatNumber)
            }
        }
    }

    override fun getItemCount(): Int {
        return suraitems.size

    }

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(pos: Int, suraitems: String, aiatitems: String)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val suraName: TextView = itemView.findViewById(R.id.sura_name)
        val aiatNumber: TextView = itemView.findViewById(R.id.aiat_number)

    }
}