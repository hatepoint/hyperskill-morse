package com.hatepoint.morsetranslator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hatepoint.morsetranslator.databinding.ActivityAlphabetBinding

class AlphabetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlphabetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlphabetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val alphabetAdapter = AlphabetAdapter()
        binding.recyclerView.adapter = alphabetAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
        alphabetAdapter.submitList(Translator().getAlphabet())
    }
}