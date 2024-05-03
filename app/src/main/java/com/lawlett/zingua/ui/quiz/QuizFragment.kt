package com.lawlett.zingua.ui.quiz

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.core.extensions.createDialog
import com.lawlett.zingua.databinding.CorrectDialogBinding
import com.lawlett.zingua.databinding.FragmentQuizBinding
import com.lawlett.zingua.ui.grammar.AnswerModel
import com.lawlett.zingua.ui.grammar.QuestionModel
import com.lawlett.zingua.ui.quiz.model.ResultQuizModel


class QuizFragment : Fragment(R.layout.fragment_quiz) {
    private val binding: FragmentQuizBinding by viewBinding()
//    val btnLogOut: Button = binding.answerBtn

    //index
    val listQuestionModel = arrayListOf<QuestionModel>()

    private var currentIndex = 0
    private var k = 0
    var level = 0
    var listSize = 0
    var rightAnswerAmount = 0
    var wrongAnswerAmount = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        listQuestionModel.add(
            QuestionModel(
                "How old Altynai ?",
                answers = arrayListOf(
                    AnswerModel(text = "15", isCorrect = true),
                    AnswerModel(text = "17", isCorrect = false),
                    AnswerModel(text = "19", isCorrect = false),
                    AnswerModel(text = "21", isCorrect = false)
                )
            )
        )
        listQuestionModel.add(
            QuestionModel(
                "How old Azamat ?",
                answers = arrayListOf(
                    AnswerModel(text = "15", isCorrect = false),
                    AnswerModel(text = "21", isCorrect = false),
                    AnswerModel(text = "24", isCorrect = true),
                    AnswerModel(text = "25", isCorrect = false)
                )
            )
        )
        listQuestionModel.add(
            QuestionModel(
                "How old are you ?",
                answers = arrayListOf(
                    AnswerModel(text = "12", isCorrect = false),
                    AnswerModel(text = "14", isCorrect = true),
                    AnswerModel(text = "4", isCorrect = false),
                    AnswerModel(text = "50", isCorrect = false)
                )
            )
        )

        updateQuestion(listQuestionModel)

        binding.answerBtn.setOnClickListener {
            val check = view?.findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId)
            val correctAnswer = listQuestionModel[level].answers.single { s -> s.isCorrect }
            listSize = listQuestionModel.size - 1
            listQuestionModel.forEach {
                it.answers.shuffle()
            }

            if (check == null) return@setOnClickListener

            if (check.text == correctAnswer.text) {
               // Toast.makeText(requireContext(), "Правильно!", Toast.LENGTH_SHORT).show()
                rightAnswerAmount++
                if (level != listSize) {
                    level++
                } else {
                    val resultModel = ResultQuizModel(
                        allQuestion = level.toString(),
                        rightAnswer = rightAnswerAmount.toString(),
                        wrongAnswer = wrongAnswerAmount.toString(),
                        time = ""
                    )
                    val bundle = Bundle()
                    bundle.putSerializable("result", resultModel)
                    findNavController().navigate(R.id.resultFragment, bundle) //открыть результат
                }

                showDialog()
            } else {
                showDialog()
               // Toast.makeText(requireContext(), "Не правильно", Toast.LENGTH_SHORT).show()
                wrongAnswerAmount++
            }
        }
    }

    private fun updateQuestion(listQuestionModel: ArrayList<QuestionModel>) {
        val answerModelByLevel = listQuestionModel[level]
        val questions = answerModelByLevel.question
        val answers = answerModelByLevel.answers
        binding.questionTv.text = questions
        binding.firstRadioBt.text = answers[0].text
        binding.secondRadioBt.text = answers[1].text
        binding.thirdRadioBt.text = answers[2].text
        binding.fourRadioBt.text = answers[3].text
    }

    private fun showDialog() {
        val dialog = requireContext().createDialog(CorrectDialogBinding::inflate)
        dialog.first.yesBtn.setOnClickListener {
           // Toast.makeText(requireContext(), "Так держать!!!", Toast.LENGTH_SHORT)
                //.show()
            updateQuestion(listQuestionModel)
            dialog.second.dismiss()
        }

        dialog.first.noBtn.setOnClickListener {
            val resultModel = ResultQuizModel(
                allQuestion = level.toString(),
                rightAnswer = rightAnswerAmount.toString(),
                wrongAnswer = wrongAnswerAmount.toString(),
                time = ""
            )
            val bundle = Bundle()
            bundle.putSerializable("result", resultModel)
            findNavController().navigate(R.id.resultFragment, bundle)
            dialog.second.dismiss()
        }
        dialog.second.show()
    }
}

//    private fun showCustomDialogBox(messege: String?) {
//        val dialog = Dialog(requireContext())
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setCancelable(false)
//        dialog.setContentView(R.layout.our_dialog)
//        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//
//        val tvMessege: TextView = dialog.findViewById(R.id.dig_tx)
//        val btnYes: Button = dialog.findViewById(R.id.Certainly_dig_bt)
//        val btnNo: Button = dialog.findViewById(R.id.no_dig_bt)
//
//        tvMessege.text = messege
//        btnNo.setOnClickListener {
//            findNavController().navigate(R.id.finish_Fragment)
//        }
//        btnYes.setOnClickListener {
//            Toast.makeText(requireContext(), "click on Yes!!", Toast.LENGTH_LONG).show()
//
//        }
//        dialog.show()
// }




