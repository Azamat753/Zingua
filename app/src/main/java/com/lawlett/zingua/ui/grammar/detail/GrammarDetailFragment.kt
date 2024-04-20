package com.lawlett.zingua.ui.grammar.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentGrammarDetailBinding
import com.lawlett.zingua.databinding.FragmentHomeBinding


class GrammarDetailFragment : Fragment(R.layout.fragment_grammar_detail) {
  val binding: FragmentGrammarDetailBinding by viewBinding()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}