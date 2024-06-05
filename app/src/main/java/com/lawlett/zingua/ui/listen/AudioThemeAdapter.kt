package com.lawlett.zingua.ui.listen

import com.lawlett.zingua.R
import com.lawlett.zingua.core.BaseAdapter
import com.lawlett.zingua.databinding.ItemGrammarThemeBinding

class AudioThemeAdapter : BaseAdapter<AudioModel,ItemGrammarThemeBinding>(
    R.layout.item_grammar_theme,
    listOf(),
    ItemGrammarThemeBinding::inflate
){
    override fun onBind(binding: ItemGrammarThemeBinding, model: AudioModel) {
        binding.titleTv.text=model.nameTheme
        binding.itNum.text= itemPosition.toString()
    }
}