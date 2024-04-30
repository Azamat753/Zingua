package com.lawlett.zingua

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.databinding.FragmentFinishBinding

class Finish_Fragment : Fragment(R.layout.fragment_finish_){
val binding: FragmentFinishBinding by viewBinding()

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

    }

}