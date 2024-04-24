package com.lawlett.zingua.ui.speaking

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentHomeBinding

class SpeakingFragment : Fragment(R.layout.fragment_speaking) {
  val binding: FragmentHomeBinding by viewBinding()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

  }
}