package com.lawlett.zingua.ui.notifications

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentAudioBinding

@Suppress("LABEL_NAME_CLASH")
class AudioFragment : Fragment(R.layout.fragment_audio) {
    val binding: FragmentAudioBinding by viewBinding()
    private lateinit var mediaPlayer: MediaPlayer
    //private var adapter = GrammarThemeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //audioQuiz()

        binding.imvPlayNoti.setOnClickListener {
            if (!this::mediaPlayer.isInitialized) {
                mediaPlayer = MediaPlayer.create(requireContext(), R.raw.audio_two)
            }
            binding.imvStopNotificat.setOnClickListener {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.pause()
                    mediaPlayer.seekTo(0)
                }
                return@setOnClickListener
            }
            mediaPlayer.start()
        }
        binding.btnAudioUnderstend.setOnClickListener {
            findNavController().navigate(R.id.quizFragment)
        }

    }
    override fun onDestroy() {
        if (this::mediaPlayer.isInitialized) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
        super.onDestroy()
    }

}

//    private fun audioQuiz() {
//        val audiolistModel = arrayListOf<QuestionModel>()
//        audiolistModel.apply {
//            add(
//                QuestionModel(
//                    " Переведи с английского на русский\nI need to find a bank",
//                    answers = arrayListOf(
//                        AnswerModel("Мне нужно найти банк", true),
//                        AnswerModel("Мне нужно в банк", false),
//                        AnswerModel("Я иду в банк", false),
//                        AnswerModel("Мне нужно идти банк", false)
//                    )
//                )
//            )
//
//        }
//        binding.btnAudioUnderstend.setOnClickListener {
//            onClick(audiolistModel.first())
//        }
//    }

//    fun onClick(model: QuestionModel){
//        val bundle= Bundle()
//        bundle.putSerializable("audio",model)
//        findNavController().navigate(R.id.quizFragment)
//
//    }
