package com.afnanelfazary.islamiapp.hadeethdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.afnanelfazary.islamiapp.R

class HadeethContentAdapter : RecyclerView.Adapter<HadeethContentAdapter.ViewHolder>() {
    var items: List<String>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadeeth_details, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content: String? = items?.get(position)
        holder.content.setText(content)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0;
    }


    fun changeData(ahadeeth: List<String>) {
        this.items = ahadeeth
        notifyDataSetChanged()//reload
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.content)

    }
}
