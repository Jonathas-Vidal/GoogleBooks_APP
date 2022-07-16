package com.jonathasdev.googlebooks.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonathasdev.googlebooks.Model.BookHttp
import com.jonathasdev.googlebooks.Model.Volume
import com.jonathasdev.googlebooks.Model.VolumeInfo
import com.jonathasdev.googlebooks.databinding.ActivityMainBinding
import com.jonathasdev.googlebooks.ui.Adapter.BookListAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView2.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launch {
            val result = withContext(Dispatchers.IO) {
                BookHttp.searchBook("Dominando o Android")
            }
            result?.items?.let { it ->
                binding.recyclerView2.adapter = BookListAdapter(it,this@MainActivity::openBookDetail)
            }
        }
    }
    private fun openBookDetail(volume: Volume) {
        BookDetailActivity.open(this,volume)
    }
}