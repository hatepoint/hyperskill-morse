package com.hatepoint.morsetranslator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.hatepoint.morsetranslator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val translator = Translator()
    private var isUpdatingEditTexts = false
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btClear.setOnClickListener {
            clearFields()
        }

        binding.etText.doOnTextChanged { text, _, _, _ ->
            if (!isUpdatingEditTexts) {
                isUpdatingEditTexts = true
                binding.etMorse.setText(translator.translateToMorse(text.toString()))
                isUpdatingEditTexts = false
            }
        }

        binding.etMorse.doOnTextChanged { text, _, _, _ ->
            if (!isUpdatingEditTexts) {
                isUpdatingEditTexts = true
                binding.etText.setText(translator.translateFromMorse(text.toString()))
                isUpdatingEditTexts = false
            }
        }

        binding.btGuide.setOnClickListener {
            val intent = Intent(this, AlphabetActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clearFields() {
        binding.etMorse.setText("")
        binding.etText.setText("")
    }
}