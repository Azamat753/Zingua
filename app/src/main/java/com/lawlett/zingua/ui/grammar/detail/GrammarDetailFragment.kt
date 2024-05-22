package com.lawlett.zingua.ui.grammar.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentGrammarDetailBinding
import com.lawlett.zingua.ui.grammar.GrammarModel


class GrammarDetailFragment : Fragment(R.layout.fragment_grammar_detail) {
    val binding: FragmentGrammarDetailBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val grammarModel = arguments?.getSerializable("grammar") as? GrammarModel
        if (grammarModel != null) {
            // val additionalTextView = binding.additionalTextView
            binding.themeNameTextView.text = grammarModel.nameOfTheme
            binding.examplesTv.text = grammarModel.examples
            binding.questionTv.text = grammarModel.questionTime
            binding.negativeTv.text = grammarModel.negative
            binding.rulesTv.text = grammarModel.ruleOfCompilation

            initClickers(grammarModel)

        }
    }

    private fun initClickers(model: GrammarModel) {
        binding.btnUnderstend.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("grammar", model)
            findNavController().navigate(R.id.quizFragment, bundle)

        }
    }
}