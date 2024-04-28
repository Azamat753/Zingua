package com.lawlett.zingua.ui.speaking

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentHomeBinding
import com.lawlett.zingua.databinding.FragmentSpeakingBinding

class SpeakingFragment : Fragment(R.layout.fragment_speaking) {
    val binding: FragmentSpeakingBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.testBtn.setOnClickListener {
            //todo Переход на другой экран по id фрагмента
            findNavController().navigate(R.id.speakingDetailFragment)
        }
    }
}