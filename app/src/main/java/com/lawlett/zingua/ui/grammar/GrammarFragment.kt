package com.lawlett.zingua.ui.grammar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.core.BaseAdapter
import com.lawlett.zingua.databinding.FragmentGrammarBinding
import com.lawlett.zingua.ui.grammar.adapter.GrammarThemeAdapter

class GrammarFragment : Fragment(R.layout.fragment_grammar),
    BaseAdapter.IBaseAdapterClickListener<GrammarModel> {
    private val binding: FragmentGrammarBinding by viewBinding()
    private var adapter = GrammarThemeAdapter()
    private var list = arrayListOf<GrammarModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        initAdapter()
    }

    private fun initAdapter() {
        val listQuestionModel = arrayListOf<QuestionModel>()
        listQuestionModel.add(
            QuestionModel(
                "How old Altynai ?",
                answers = arrayListOf(
                    AnswerModel(text = "15", isCorrect = false),
                    AnswerModel(text = "17", isCorrect = false),
                    AnswerModel(text = "19", isCorrect = true),
                    AnswerModel(text = "21", isCorrect = false)
                )
            )
        )

        list.add(
            GrammarModel(
                nameOfTheme = "Past Simple",
                ruleOfCompilation = "hdjsahdjsadhas",
                examples = "das",
                listQuestionModels = listQuestionModel
            )
        )
        adapter.setData(list)
        adapter.listener = this
        binding.recyclerView.adapter = adapter
    }

    private fun initClickers() {


    }

    override fun onClick(model: GrammarModel, position: Int) {
        val bundle = Bundle()
        bundle.putSerializable("grammar", model)
        findNavController().navigate(R.id.grammarDetailFragment, bundle)
    }
}