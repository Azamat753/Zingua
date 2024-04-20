package com.lawlett.zingua.ui.grammar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentGrammarBinding
import com.lawlett.zingua.databinding.FragmentHomeBinding

class GrammarFragment : Fragment(R.layout.fragment_grammar) {
  val binding: FragmentGrammarBinding by viewBinding()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initClickers()
  }

  private fun initClickers() {
    binding.btn.setOnClickListener {
      findNavController().navigate(R.id.grammarDetailFragment)
    }
  }
}