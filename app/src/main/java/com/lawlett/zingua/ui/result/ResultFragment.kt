package com.lawlett.zingua.ui.result

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.MainActivity
import com.lawlett.zingua.R
import com.lawlett.zingua.core.extensions.getCurrentDateTime
import com.lawlett.zingua.databinding.FragmentResultBinding
import com.lawlett.zingua.ui.quiz.model.ResultQuizModel
import java.text.SimpleDateFormat
import java.util.Date

class ResultFragment : Fragment(R.layout.fragment_result) {
    val binding: FragmentResultBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var azamat = arguments?.getSerializable("result") as ResultQuizModel
        val oldDate = arguments?.getSerializable("date") as Date
        val endDate = getCurrentDateTime()
        val time = endDate.time - oldDate.time
        //val allQuestionss = azamat.allQuestion

        binding.questionTvResult.text = azamat.allQuestion
        binding.correctAnswerResult.text= azamat.rightAnswer
        binding.mistakeTvResult.text = azamat.wrongAnswer
        binding.timeResultTv.text = convertLongToTime(time)
        binding.homeBtn.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            requireContext().startActivity(intent)
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("mm:ss")
        return format.format(date)
    }
}