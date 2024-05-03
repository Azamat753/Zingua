package com.lawlett.zingua

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.databinding.FragmentResultBinding
import com.lawlett.zingua.ui.quiz.model.ResultQuizModel

class ResultFragment : Fragment(R.layout.fragment_result){
val binding: FragmentResultBinding by viewBinding()


    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        var azamat = arguments?.getSerializable("result") as ResultQuizModel
        binding.questionTvResult.text = azamat.allQuestion
        binding.correctAnswerResult.text= azamat.rightAnswer
        binding.mistakeTvResult.text = azamat.wrongAnswer
 binding.homeBtn.setOnClickListener {

         val intent = Intent(requireContext(), MainActivity :: class.java)
         requireContext().startActivity(intent)

 }

    }

}