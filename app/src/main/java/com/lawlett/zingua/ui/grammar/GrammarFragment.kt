package com.lawlett.zingua.ui.grammar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.core.BaseAdapter
import com.lawlett.zingua.databinding.FragmentGrammarBinding

class GrammarFragment : Fragment(R.layout.fragment_grammar),BaseAdapter.IBaseAdapterClickListener<GrammarModel> {
  private val binding: FragmentGrammarBinding by viewBinding()
  private var adapter = GrammarThemeAdapter()
  private var list = arrayListOf<GrammarModel>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initClickers()
    initAdapter()
  }

  private fun initAdapter() {
    list.add(GrammarModel("Past Simple"))
    list.add(GrammarModel("Present Simple"))
    adapter.setData(list)
    binding.recyclerView.adapter = adapter
  }

  private fun initClickers() {


  }

  override fun onClick(model: GrammarModel, position: Int) {

  }
}