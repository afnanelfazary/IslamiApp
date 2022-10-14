package com.afnanelfazary.islamiapp.home.hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.afnanelfazary.islamiapp.R

class HadeethNamesAdapter(val hadeethitems: List<String>) :
    RecyclerView.Adapter<HadeethNamesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HadeethNamesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadeeth, parent, false)
        return HadeethNamesAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeethNumber = hadeethitems.get(position)
        holder.hadeethNumber.setText(hadeethNumber)
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, hadeethNumber)
            }
        }
    }


    override fun getItemCount(): Int {
        return hadeethitems.size

    }

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(pos: Int, hadeethitems: String)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hadeethNumber: TextView = itemView.findViewById(R.id.hadeth_number)

    }
}