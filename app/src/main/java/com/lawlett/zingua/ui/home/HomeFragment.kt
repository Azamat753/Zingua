package com.lawlett.zingua.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
  private val binding: FragmentHomeBinding by viewBinding()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.textHome.text = "Home"
  }
}