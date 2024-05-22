package com.lawlett.zingua.ui.grammar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        initAdapter()

    }

    private fun initAdapter() {
        val pastListQuestionModel = arrayListOf<QuestionModel>()
        pastListQuestionModel.apply {
            add(
                QuestionModel(
                    "Как задать вопрос \n\"Ты играл в футбол вчера?\"?",
                    answers = arrayListOf(
                        AnswerModel(text = " Did you plays soccer yesterday?", isCorrect = false),
                        AnswerModel(text = " Did you played soccer yesterday?", isCorrect = false),
                        AnswerModel(text = " Did you play soccer yesterday?", isCorrect = true),
                        AnswerModel(text = " Do you play soccer yesterday?", isCorrect = false)
                    )
                )
            )
            add(
                QuestionModel(
                    "Как задать вопрос\n \"Она пошла в магазин?\"",
                    answers = arrayListOf(
                        AnswerModel(text = " Did she goes to the store?", isCorrect = false),
                        AnswerModel(text = " Did she went to the store?", isCorrect = false),
                        AnswerModel(text = " Does she go to the store?", isCorrect = false),
                        AnswerModel(text = " Did she go to the store?", isCorrect = true)
                    )

                )
            )
            add(
                QuestionModel(
                    "Как задать вопрос\n \"Они смотрели фильм?\"",
                    answers = arrayListOf(
                        AnswerModel(text = " Did they watch a movie?", isCorrect = true),
                        AnswerModel(text = " Do they watched a movie?", isCorrect = false),
                        AnswerModel(text = " Did they watched a movie?", isCorrect = false),
                        AnswerModel(text = " Did they watches a movie?", isCorrect = false)
                    )

                )
            )
            add(
                QuestionModel(
                    "Как задать вопрос \n\"Он поел завтрак?\"",
                    answers = arrayListOf(
                        AnswerModel(text = " Did he eat breakfast?", isCorrect = true),
                        AnswerModel(text = " Does he ate breakfast?", isCorrect = false),
                        AnswerModel(text = " Did he ate breakfast?", isCorrect = false),
                        AnswerModel(text = " Did he eats breakfast?", isCorrect = false)
                    )

                )
            )
            add(
                QuestionModel(
                    "Как задать вопрос\n \"Мы закончили проект?\"",
                    answers = arrayListOf(
                        AnswerModel(text = " Did we finished the project?", isCorrect = false),
                        AnswerModel(text = " Did we finishes the project?", isCorrect = false),
                        AnswerModel(text = " Did we finish the project?", isCorrect = true),
                        AnswerModel(text = " Does we finish the project?", isCorrect = false)
                    )

                )
            )
            add(
                QuestionModel(
                    "Как задать вопрос\n \"Она училась вчера?\"",
                    answers = arrayListOf(
                        AnswerModel(text = " Did she study yesterday?", isCorrect = true),
                        AnswerModel(text = " Did she studied yesterday?", isCorrect = false),
                        AnswerModel(text = " Does she study yesterday?", isCorrect = false),
                        AnswerModel(text = " Did she studies yesterday?", isCorrect = false)
                    )

                )

            )
        }
        pastListQuestionModel.shuffle()
        pastListQuestionModel.first().answers.shuffle()
        val presentListQuestionModel = arrayListOf<QuestionModel>()
        presentListQuestionModel.apply {
            add(
                QuestionModel(
                    "Как задать вопрос\n \"Ты играешь в футбол каждый день?\"",
                    answers = arrayListOf(
                        AnswerModel(text = " Do you play soccer every day?", isCorrect = true),
                        AnswerModel(text = " Does you play soccer every day?", isCorrect = false),
                        AnswerModel(text = " Do you plays soccer every day?", isCorrect = false),
                        AnswerModel(text = " Does you plays soccer every day?", isCorrect = false)
                    )
                )
            )
            add(
                QuestionModel(
                    "Как задать вопрос \n\"Она ходит в магазин каждый день?\"",
                    answers = arrayListOf(
                        AnswerModel(
                            text = " Does she goes to the store every day?",
                            isCorrect = false
                        ),
                        AnswerModel(
                            text = " Do she go to the store every day?",
                            isCorrect = false
                        ),
                        AnswerModel(
                            text = " Does she go to the store every day?",
                            isCorrect = true
                        ),
                        AnswerModel(
                            text = " Do she goes to the store every day?",
                            isCorrect = false
                        )
                    )
                )
            )
            add(
                QuestionModel(
                            "Как задать вопрос \n\"Они смотрят фильмы по выходным?\" ",
                    answers = arrayListOf(
                        AnswerModel(
                            text = " Do they watch movies on weekends?",
                            isCorrect = true
                        ),
                        AnswerModel(
                            text = " Does they watch movies on weekends?",
                            isCorrect = false
                        ),
                        AnswerModel(
                            text = " Do they watches movies on weekends?",
                            isCorrect = false
                        ),
                        AnswerModel(
                            text = " Does they watches movies on weekends?",
                            isCorrect = false
                        )
                    )
                )
            )
            add(
                QuestionModel(
                            "Как задать вопрос\n \"Он завтракает каждый день?\" ",
                    answers = arrayListOf(
                        AnswerModel(text = " Does he eats breakfast every day?", isCorrect = false),
                        AnswerModel(text = " Do he eat breakfast every day?", isCorrect = false),
                        AnswerModel(text = " Do he eats breakfast every day?", isCorrect = false),
                        AnswerModel(text = " Does he eat breakfast every day?", isCorrect = true)
                    )
                )
            )
            add(
                QuestionModel(
                            "Как задать вопрос\n \"Мы заканчиваем работу в 6 часов?\"",
                    answers = arrayListOf(
                        AnswerModel(
                            text = " Does we finish work at 6 o'clock?",
                            isCorrect = false
                        ),
                        AnswerModel(
                            text = " Do we finishes work at 6 o'clock?",
                            isCorrect = false
                        ),
                        AnswerModel(
                            text = " Does we finishes work at 6 o'clock?",
                            isCorrect = false
                        ),
                        AnswerModel(text = " Do we finish work at 6 o'clock?", isCorrect = true)
                    )
                )
            )
            add(
                QuestionModel(
                            "Как задать вопрос \n\"Она учится каждый день?\"",
                    answers = arrayListOf(
                        AnswerModel(text = " Do she studies every day?", isCorrect = false),
                        AnswerModel(text = " Does she study every day?", isCorrect = true),
                        AnswerModel(text = " Does she studies every day?", isCorrect = false),
                        AnswerModel(text = " Do she study every day?", isCorrect = false)
                    )
                )
            )
            add(
                QuestionModel(
                            "Как задать вопрос \n\"Он работает здесь?\"",
                    answers = arrayListOf(
                        AnswerModel(text = " Do he work here?", isCorrect = false),
                        AnswerModel(text = " Does he works here?", isCorrect = false),
                        AnswerModel(text = " Does he work here?", isCorrect = false),
                        AnswerModel(text = " Do he works here?", isCorrect = true)
                    )
                )
            )
        }

        val futureListQuestionModel = arrayListOf<QuestionModel>()
        futureListQuestionModel.add(
            QuestionModel(
                "What is it Future Simple?",
                answers = arrayListOf(
                    AnswerModel(text = "arrayOf", isCorrect = false),
                    AnswerModel(text = "Present", isCorrect = false),
                    AnswerModel(text = "Future Simple", isCorrect = true),
                    AnswerModel(text = "das", isCorrect = false)
                )
            )
        )
        val list = ArrayList<GrammarModel>()
        val pastSimpleModel = GrammarModel(
            nameOfTheme = "Past Simple ",
            ruleOfCompilation = getString(R.string.pastsimple),
            examples = getString(R.string.pastsimpleexample1),
            questionTime = getString(R.string.pastsimpleexample2),
            negative = getString(R.string.pastsimpleexample3),
            listQuestionModels = pastListQuestionModel
            //text = "Text for Past Simple theme"
        )
        val presentSimpleModel = GrammarModel(
            nameOfTheme = "Present Simple",
            ruleOfCompilation = getString(R.string.rule_of_present_simple),
            examples = getString(R.string.present_simple_examples1),
            questionTime = getString(R.string.presentquestiontime),
            negative = getString(R.string.negativepresent),
            listQuestionModels = presentListQuestionModel
        )
        val futureSimpleModel = GrammarModel(
            nameOfTheme = "Future Simple",
            ruleOfCompilation = getString(R.string.rule_of_future_simple),
            examples = getString(R.string.future_simple_examples),
            questionTime = getString(R.string.questionfuture),
            negative = getString(R.string.negativefuture),
            listQuestionModels = futureListQuestionModel
        )
        list.add(pastSimpleModel)
        list.add(presentSimpleModel)
        list.add(futureSimpleModel)
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