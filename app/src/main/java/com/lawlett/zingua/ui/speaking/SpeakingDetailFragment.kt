package com.lawlett.zingua.ui.speaking

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentSpeakingDetailBinding

class SpeakingDetailFragment : Fragment(R.layout.fragment_speaking_detail) {

    val binding: FragmentSpeakingDetailBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleTv.text = "Altynaaaaaai"
    }
}