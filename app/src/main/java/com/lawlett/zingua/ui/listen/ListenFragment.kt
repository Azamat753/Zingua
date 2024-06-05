package com.lawlett.zingua.ui.listen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.core.BaseAdapter
import com.lawlett.zingua.databinding.FragmentListenBinding
import com.lawlett.zingua.ui.grammar.AnswerModel
import com.lawlett.zingua.ui.grammar.QuestionModel

class ListenFragment : Fragment(R.layout.fragment_listen),
    BaseAdapter.IBaseAdapterClickListener<AudioModel> {
    private val binding: FragmentListenBinding by viewBinding()
    private var adapter = AudioThemeAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        audioQuiz()
        initClickers()
    }

    private fun audioQuiz() {
        val dialogAudioListModel = arrayListOf<QuestionModel>()
        dialogAudioListModel.apply {
            add(
                QuestionModel(
                    " Переведи с английского на русский?\nI need to find a bank",
                    arrayListOf(
                        AnswerModel("Мне нужно найти банк", true),
                        AnswerModel("Мне нужно в банк", false),
                        AnswerModel("Я иду в банк", false),
                        AnswerModel("Мне нужно идти банк", false)
                    ), R.raw.music
                )
            )
            add(
               QuestionModel(
                    "\nI need to find a bank",
                    arrayListOf(
                        AnswerModel("Мне нужно найти банк", true),
                        AnswerModel("Мне нужно в банк", false),
                        AnswerModel("Я иду в банк", false),
                        AnswerModel("Мне нужно идти банк", false)
                    ),R.raw.music
                )
            )
            add(
                QuestionModel(
                    "\n?",
                    arrayListOf(
                        AnswerModel("Мне нужно найти банк", true),
                        AnswerModel("Мне нужно в банк", false),
                        AnswerModel("Я иду в банк", false),
                        AnswerModel("Мне нужно идти банк", false)
                    ),R.raw.music
                )
            )

        }
        dialogAudioListModel.shuffle()
        //dialogAudioListModel.first().answers.shuffle()
        val musicAudioListModel = arrayListOf<QuestionModel>()
        musicAudioListModel.apply {
            add(
                QuestionModel(
                    "песня грустная или веселая?",
                    arrayListOf(
                        AnswerModel("Да", true),
                        AnswerModel("нет", false),
                        AnswerModel("arrayListOf", false),
                        AnswerModel("apply", false)
                    ),R.raw.music
                )
            )
        }
        val dictionaryListModel = arrayListOf<QuestionModel>()
        dictionaryListModel.apply {
            add(
                QuestionModel(
                    "Переведите фразу",
                    arrayListOf(
                        AnswerModel("AnswerModel", true),
                        AnswerModel("AnswerModel1", false),
                        AnswerModel("AnswerModel2", false),
                        AnswerModel("AnswerModel3", false)
                    ),R.raw.music
                )
            )
        }
        val list = ArrayList<AudioModel>()
        val audioRv = AudioModel(
            "Диалоги",
            dialogAudioListModel
        )
        val musicRvList = AudioModel(
            "Песни",
            musicAudioListModel
        )
        
        list.add(audioRv)
        list.add(musicRvList)
        adapter.setData(list)
        adapter.listener = this
        binding.rcAudio.adapter = adapter

    }

    private fun initClickers() {
    }

    override fun onClick(model: AudioModel, position: Int) {
        val bundle = Bundle()
        bundle.putSerializable("audio", model)
        findNavController().navigate(R.id.audioFragment, bundle)
    }
}

