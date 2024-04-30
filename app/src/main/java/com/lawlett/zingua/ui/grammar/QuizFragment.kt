package com.lawlett.zingua.ui.grammar

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.databinding.FragmentQuizBinding


class QuizFragment : Fragment(R.layout.fragment_quiz) {
    private val binding: FragmentQuizBinding by viewBinding()
val btnLogOut : Button = binding.answerBtn
    //index
    var level = 0
    var listSize = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        btnLogOut.setOnClickListener {
            val messege : String? = "Идём дальше?"
            showCustomDialogBox(messege)
        }
    }
private fun showCustomDialogBox(messege: String?){
    val dialog = Dialog(requireContext())
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.our_dialog)
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    val tvMessege :TextView =  dialog.findViewById(R.id.dig_tx)
    val btnYes : Button= dialog.findViewById(R.id.Certainly_dig_bt)
    val btnNo : Button = dialog.findViewById(R.id.no_dig_bt)

    tvMessege.text=messege
btnNo.setOnClickListener {
    findNavController().navigate(R.id.finish_Fragment)
}
    btnYes.setOnClickListener {
        Toast.makeText(requireContext(), "click on Yes!!", Toast.LENGTH_LONG).show()

    }
    dialog.show()
}
    private fun initClickers() {
        val listQuestionModel = arrayListOf<QuestionModel>()
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
        listSize = listQuestionModel.size - 1
        listQuestionModel.forEach {
            it.answers.shuffle()
        }

        showQuestion(listQuestionModel)


        binding.answerBtn.setOnClickListener {
            val check = view?.findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId)
            val correctAnswer = listQuestionModel[level].answers.single { s -> s.isCorrect }
            if (check?.text == correctAnswer.text) {

                Toast.makeText(requireContext(), "Правильно", Toast.LENGTH_SHORT).show()
                if (level != listSize) {
                    level++
                    showQuestion(listQuestionModel)
                }else{
                    val bundle = Bundle()
                    bundle.putSerializable("finish", listQuestionModel )
                    findNavController().navigate(R.id.finish_Fragment) //открыть результат
                }

           }
            //else {
//                Toast.makeText(requireContext(), "Не правильно", Toast.LENGTH_SHORT).show()
//            }

        }
    }

    private fun showQuestion(listQuestionModel: ArrayList<QuestionModel>) {
        val answerModelByLevel = listQuestionModel[level]
        val questions = answerModelByLevel.question
        val answers = answerModelByLevel.answers
        binding.questionTv.text = questions
        binding.firstRadioBt.text = answers[0].text
        binding.secondRadioBt.text = answers[1].text
        binding.thirdRadioBt.text = answers[2].text
        binding.fourRadioBt.text = answers[3].text
    }
}
