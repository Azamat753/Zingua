package com.lawlett.zingua.ui.grammar.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentGrammarDetailBinding
import com.lawlett.zingua.ui.grammar.GrammarModel


class GrammarDetailFragment : Fragment(R.layout.fragment_grammar_detail) {
    val binding: FragmentGrammarDetailBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var altynai = arguments?.getSerializable("grammar") as GrammarModel
        binding.titleTv.text = altynai.listQuestionModels.first().question
        initClickers()

    }

    private fun initClickers() {
        binding.btnUnderstend.setOnClickListener {
            findNavController().navigate(R.id.quizFragment)

        }
    }

    fun onClick(model: GrammarModel, position: Int) {
        val bundle = Bundle()
        bundle.putSerializable("grammar", model)
        findNavController().navigate(R.id.grammarDetailFragment, bundle)
    }


}