package com.hatepoint.morsetranslator

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import androidx.core.text.bold
import androidx.core.text.inSpans
import androidx.core.text.italic
import androidx.core.text.toSpannable
import androidx.recyclerview.widget.GridLayoutManager
import com.hatepoint.morsetranslator.databinding.ActivityAlphabetBinding

class AlphabetActivity : AppCompatActivity() {

    companion object {
        val spanDescriptionText = SpannableStringBuilder()
            .append("Letters are separated with ")
            .inSpans(StyleSpan(Typeface.BOLD_ITALIC)) {
                append("one space")
            }.append(", words are separated with ")
            .inSpans(StyleSpan(Typeface.BOLD_ITALIC)) {
                append("3 spaces")
            }.append(". Unknown symbols will be displayed as '?'")
            .toSpannable()
    }

    private lateinit var binding: ActivityAlphabetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlphabetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val alphabetAdapter = AlphabetAdapter()
        binding.recyclerView.adapter = alphabetAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
        alphabetAdapter.submitList(Translator().getAlphabet())
        binding.textDescription.text = spanDescriptionText
    }
}