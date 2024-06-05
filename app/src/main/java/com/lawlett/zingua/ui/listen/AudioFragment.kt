package com.lawlett.zingua.ui.listen

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
    private lateinit var audioModel: AudioModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        audioModel = arguments?.getSerializable("audio") as AudioModel
        initClickers()

        binding.imvPlayNoti.setOnClickListener {
            if (!this::mediaPlayer.isInitialized) {
                mediaPlayer = MediaPlayer.create(requireContext(), audioModel.listQuestionModels.first().audio!!)
            }
            binding.imvStopNotificat.setOnClickListener {
                var a = R.raw.audio_two
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.pause()
                    mediaPlayer.seekTo(0)
                }
                return@setOnClickListener
            }
            mediaPlayer.start()
        }


    }

    private fun initClickers() {
        binding.btnAudioUnderstend.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("audio", audioModel)
            findNavController().navigate(R.id.quizFragment, bundle)
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
