package com.lawlett.zingua.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.core.extensions.getCurrentDateTime
import com.lawlett.zingua.core.extensions.toString
import com.lawlett.zingua.databinding.FragmentHomeBinding
import java.util.Locale

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding: FragmentHomeBinding by viewBinding()
    var motive = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val date = getCurrentDateTime()
        val dateInString = date.toString("dd MMMM",Locale("ru"))

        binding.textHome.text = dateInString
        binding.quotesHome.text =
            "\"There is no secret of success. It's the result of preparation, hard work, and learning from failure.\""
        binding.btTranslate.setOnClickListener {
            if (motive) {
                binding.quotesHome.text =
                    "\"Секрета успеха нет. Это результат подготовки, упорного труда и извлечения уроков из неудач\"."
            } else {
                binding.quotesHome.text =
                    "\"There is no secret of success. It's the result of preparation, hard work, and learning from failure.\""
            }
            motive = !motive
        }
    }
}