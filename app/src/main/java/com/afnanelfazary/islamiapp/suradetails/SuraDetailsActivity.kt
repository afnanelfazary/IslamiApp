package com.afnanelfazary.islamiapp.suradetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.afnanelfazary.islamiapp.Constants
import com.afnanelfazary.islamiapp.R
import com.afnanelfazary.islamiapp.databinding.ActivitySuraDetailsBinding

class SuraDetailsActivity : AppCompatActivity() {

     private lateinit var binding: ActivitySuraDetailsBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        initRecyclerView()
        val sura_Name: String = intent.getStringExtra(Constants.EXTRA_SURA_NAME) as String
        val sura_Position: Int = intent.getIntExtra(Constants.EXTRA_SURA_Position, -1)
        val aiat_Num: String = intent.getStringExtra(Constants.EXTRA_AIAT_NUM) as String
        binding.titleTextView.setText(sura_Name)

        readSuraFile(sura_Position)

    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter
    }
    fun readSuraFile(pos: Int) {
        val fileName = "${(pos + 1)}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n")
        //show verses in recycleView
        adapter.changeData(verses)
    }
}