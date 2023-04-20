package com.example.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PlaylistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playlistRV.setHasFixedSize(true)
        binding.playlistRV.setItemViewCacheSize(10)
        binding.playlistRV.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = PlaylistAdapter(this)
        binding.playlistRV.adapter = adapter

        binding.addBtn.setOnClickListener {
            //TODO Adapter로부터 selectedList 목록 출력        }

        }
    }
}