package com.lawlett.zingua.ui.grammar.adapter

import com.lawlett.zingua.R
import com.lawlett.zingua.core.BaseAdapter
import com.lawlett.zingua.databinding.ItemGrammarThemeBinding
import com.lawlett.zingua.ui.grammar.GrammarModel

class GrammarThemeAdapter : BaseAdapter<GrammarModel, ItemGrammarThemeBinding>(
  R.layout.item_grammar_theme,
  listOf(),
  ItemGrammarThemeBinding::inflate
) {
  override fun onBind(binding: ItemGrammarThemeBinding, model: GrammarModel) {
    binding.titleTv.text = model.nameOfTheme
    binding.itNum.text= itemPosition.toString()
  }
}