package com.afnanelfazary.islamiapp.hadeethdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.afnanelfazary.islamiapp.Constants
import com.afnanelfazary.islamiapp.R
import com.afnanelfazary.islamiapp.databinding.ActivityHadeethDetailsBinding

class HadeethDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHadeethDetailsBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadeethContentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadeethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        initRecyclerView()
        val hadeeth_Num: String = intent.getStringExtra(Constants.EXTRA_Hadeeth_NAME) as String
        val hadeeth_Position: Int = intent.getIntExtra(Constants.EXTRA_HADEETH_Position, -1)
        binding.titleTextView.setText(hadeeth_Num)
        readHadeethFile(hadeeth_Position)

    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view)
        adapter = HadeethContentAdapter()
        recyclerView.adapter = adapter
    }

    fun readHadeethFile(pos: Int) {
        val fileName = "h" + "${(pos + 1)}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n")
        //show verses in recycleView
        adapter.changeData(verses)
    }
}