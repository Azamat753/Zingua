package com.lawlett.zingua.ui.notifications

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.core.BaseAdapter
import com.lawlett.zingua.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment(R.layout.fragment_notifications),
    BaseAdapter.IBaseAdapterClickListener<AudioModel> {
    private val binding: FragmentNotificationsBinding by viewBinding()
    private var adapter = AudioThemeAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        audioQuiz()
        initClickers()
    }

    private fun audioQuiz() {
        val audioListModel = arrayListOf<AudioModelList>()
        audioListModel.apply {
            add(
                AudioModelList(
                    " Переведи с английского на русский?\nI need to find a bank",
                 answer =  arrayListOf(
                        AnswerModelAudio("Мне нужно найти банк", true),
                        AnswerModelAudio("Мне нужно в банк", false),
                        AnswerModelAudio("Я иду в банк", false),
                        AnswerModelAudio("Мне нужно идти банк", false)
                    )
                )
            )
            val list = ArrayList<AudioModel>()
            val audioRv = AudioModel(
                "Диалоги",
                audioListModel
            )
            list.add(audioRv)
            adapter.setData(list)
            adapter.listener = this@NotificationsFragment
            binding.rcAudio.adapter = adapter

        }

    }
    private fun initClickers() {
    }

    override fun onClick(model: AudioModel, position: Int) {
        val bundle = Bundle()
        bundle.putSerializable("audio",model)
        findNavController().navigate(R.id.audioFragment)
    }
}
//        binding.btnAudioUnderstend.setOnClickListener {
//            onClick(audiolistModel.first())
//        }
//    }
//    fun onClick(model: QuestionModel){
//        val bundle= Bundle()
//        bundle.putSerializable("audio",model)
//        findNavController().navigate(R.id.navigation_notifications)
//
//    }

