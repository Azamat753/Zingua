package com.lawlett.zingua.ui.grammar

import com.lawlett.zingua.R
import com.lawlett.zingua.core.BaseAdapter
import com.lawlett.zingua.databinding.ItemGrammarThemeBinding

class GrammarThemeAdapter : BaseAdapter<GrammarModel, ItemGrammarThemeBinding>(
  R.layout.item_grammar_theme,
  listOf(),
  ItemGrammarThemeBinding::inflate
) {
  override fun onBind(binding: ItemGrammarThemeBinding, model: GrammarModel) {
    binding.titleTv.text = model.name
  }
}