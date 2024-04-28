package com.lawlett.zingua.ui.grammar

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentQuizBinding


class QuizFragment : Fragment(R.layout.fragment_quiz) {
  private val binding: FragmentQuizBinding by viewBinding()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initClickers()

  }

  private fun initClickers() {
    val listQuestionModel = arrayListOf<QuestionModel>()
    listQuestionModel.add(
      QuestionModel(
        "How old Altynai ?",
        answers = arrayListOf(
          AnswerModel(text = "15", isCorrect = false),
          AnswerModel(text = "17", isCorrect = false),
          AnswerModel(text = "19", isCorrect = true),
          AnswerModel(text = "21", isCorrect = false)
        )
      )
    )

    listQuestionModel.shuffle()

    listQuestionModel.forEach {
      var questions = it.question
      var answers = it.answers
      binding.questionTv.text = questions
      binding.firstRadioBt.text = answers[0].text
      binding.secondRadioBt.text = answers[1].text
      binding.thirdRadioBt.text = answers[2].text
      binding.fourRadioBt.text = answers[3].text
    }

    binding.answerBtn.setOnClickListener {
      val check = view?.findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId)
      val correctAnswer = listQuestionModel[0].answers.single { s -> s.isCorrect }
      if (check?.text == correctAnswer.text) {
        Toast.makeText(requireContext(), "Правильно", Toast.LENGTH_SHORT).show()
      } else {
        Toast.makeText(requireContext(), "Не правильно", Toast.LENGTH_SHORT).show()
      }
    }
  }
}
