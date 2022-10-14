package com.afnanelfazary.islamiapp.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.afnanelfazary.islamiapp.Constants
import com.afnanelfazary.islamiapp.R
import com.afnanelfazary.islamiapp.databinding.FragmentHadethBinding
import com.afnanelfazary.islamiapp.hadeethdetails.HadeethDetailsActivity

class HadethFragment : Fragment() {
    private lateinit var fragbinding: FragmentHadethBinding
    var hadeethitems: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragbinding = FragmentHadethBinding.inflate(inflater, container, false)
        return fragbinding.root
    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadeethNamesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        showData()
        adapter = HadeethNamesAdapter(hadeethitems)
        adapter.onItemClickListener = object : HadeethNamesAdapter.OnItemClickListener {

            override fun onItemClick(pos: Int, hadeethitems: String) {
                showHadeethDetails(pos, hadeethitems)
            }

        }
        recyclerView.adapter = adapter
    }

    fun showHadeethDetails(pos: Int, HadeethNames: String) {
        val intent = Intent(context, HadeethDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_Hadeeth_NAME, HadeethNames)
        intent.putExtra(Constants.EXTRA_HADEETH_Position, pos)

        startActivity(intent)
    }

    private fun showData() {
        var i = 1
        while (i <= 50) {
            hadeethitems.add("الحديث رقم " + i.toString())
            i++
        }
    }

}