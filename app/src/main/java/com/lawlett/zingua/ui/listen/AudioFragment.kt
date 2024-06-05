package com.lawlett.zingua.ui.listen

import android.Manifest
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentAudioBinding


class AudioFragment : Fragment(R.layout.fragment_audio) {
  val binding: FragmentAudioBinding by viewBinding()
  private lateinit var mediaPlayer: MediaPlayer
  private lateinit var audioModel: AudioModel

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    audioModel = arguments?.getSerializable("audio") as AudioModel
    initClickers()
    requestRecordAudioPermission()
  }

  private fun requestRecordAudioPermission() {
    Dexter.withContext(requireContext())
      .withPermission(Manifest.permission.RECORD_AUDIO)
      .withListener(object : PermissionListener {
        override fun onPermissionGranted(p0: PermissionGrantedResponse?) {}
        override fun onPermissionDenied(p0: PermissionDeniedResponse?) {}
        override fun onPermissionRationaleShouldBeShown(
          p0: PermissionRequest?,
          p1: PermissionToken?
        ) {
        }
      }).check()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding.blast.release();
  }

  private fun initClickers() {
    binding.btnAudioUnderstend.setOnClickListener {
      val bundle = Bundle()
      bundle.putSerializable("audio", audioModel)
      findNavController().navigate(R.id.quizFragment, bundle)
    }
    binding.imvPlayNoti.setOnClickListener {
      if (!this::mediaPlayer.isInitialized) {
        mediaPlayer =
          MediaPlayer.create(requireContext(), audioModel.listQuestionModels.first().audio!!)
        val audioSessionId = mediaPlayer.audioSessionId
        if (audioSessionId != -1) {
          binding.blast.setAudioSessionId(audioSessionId)
        }
      }
      binding.imvStopNotificat.setOnClickListener {
        if (mediaPlayer.isPlaying) {
          mediaPlayer.pause()
          mediaPlayer.seekTo(0)
        }
      }
      mediaPlayer.start()
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
