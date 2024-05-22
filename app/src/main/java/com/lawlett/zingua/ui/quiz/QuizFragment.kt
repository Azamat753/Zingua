package com.lawlett.zingua.ui.quiz

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.lawlett.zingua.R
import com.lawlett.zingua.core.extensions.createDialog
import com.lawlett.zingua.core.extensions.getCurrentDateTime
import com.lawlett.zingua.databinding.CorrectDialogBinding
import com.lawlett.zingua.databinding.DialogExitBinding
import com.lawlett.zingua.databinding.FragmentQuizBinding
import com.lawlett.zingua.databinding.WrongDialogBinding
import com.lawlett.zingua.ui.grammar.GrammarModel
import com.lawlett.zingua.ui.grammar.QuestionModel
import com.lawlett.zingua.ui.notifications.AudioModel
import com.lawlett.zingua.ui.notifications.AudioModelList
import com.lawlett.zingua.ui.quiz.model.ResultQuizModel

class QuizFragment : Fragment(R.layout.fragment_quiz) {
    private val binding: FragmentQuizBinding by viewBinding()

    //index
    private var listQuestionModel = arrayListOf<QuestionModel>()
    private var audioModelList = arrayListOf<AudioModelList>()
    val currentDate = getCurrentDateTime()

    var level = 0
    var listSize = 0
    var rightAnswerAmount = 0
    var wrongAnswerAmount = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val audioModel = arguments?.getSerializable("audio") as? AudioModel
        val model = arguments?.getSerializable("grammar") as? GrammarModel
        if (model != null) {
            listQuestionModel = model.listQuestionModels
        }
        if (audioModel!=null){
            audioModelList= audioModel.audioQuestionModel
        }
        initClickers()

        // Добавляем обработчик нажатия кнопки "Назад"
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    showExitConfirmationDialog()
                }
            })
    }

    private fun initClickers() {
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
                level++
                rightAnswerAmount++
                if (level != listSize) {
                    showDialog()
                } else {
                    val resultModel = ResultQuizModel(
                        allQuestion = level.toString(),
                        rightAnswer = rightAnswerAmount.toString(),
                        wrongAnswer = wrongAnswerAmount.toString(),
                    )
                    openResult(resultModel)
                }
            } else {
                wrongShowDialog()
                wrongAnswerAmount++
            }
        }
    }

    private fun updateQuestion(listQuestionModel: ArrayList<QuestionModel>) {
        binding.radioGroup.clearCheck()
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
            Toast.makeText(requireContext(), "Так держать!!!", Toast.LENGTH_SHORT).show()
            updateQuestion(listQuestionModel)
            dialog.second.dismiss()
        }

        dialog.first.noBtn.setOnClickListener {
            val levelUpd = level
            val resultModel = ResultQuizModel(
                allQuestion = levelUpd.toString(),
                rightAnswer = rightAnswerAmount.toString(),
                wrongAnswer = wrongAnswerAmount.toString(),
                )
            openResult(resultModel)
            dialog.second.dismiss()
        }
        dialog.second.show()
    }

    private fun wrongShowDialog() {
        val dialog = requireContext().createDialog(WrongDialogBinding::inflate)
        dialog.first.yesBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Так держать!!!", Toast.LENGTH_SHORT).show()
            updateQuestion(listQuestionModel)
            dialog.second.dismiss()
        }

        clickNo(dialog)
        dialog.second.show()
    }

    private fun clickNo(dialog: Pair<WrongDialogBinding, Dialog>) {
        dialog.first.noBtn.setOnClickListener {
            val levelUpd = level + 1
            val resultModel = ResultQuizModel(
                allQuestion = levelUpd.toString(),
                rightAnswer = rightAnswerAmount.toString(),
                wrongAnswer = wrongAnswerAmount.toString(),
            )
            openResult(resultModel)
            dialog.second.dismiss()
        }
    }

    private fun openResult(resultModel: ResultQuizModel) {
        val bundle = Bundle()
        bundle.putSerializable("result", resultModel)
        bundle.putSerializable("date", currentDate)
        findNavController().navigate(R.id.resultFragment, bundle)
    }

    private fun showExitConfirmationDialog() {
        val dialogEx = requireContext().createDialog(DialogExitBinding::inflate)
        dialogEx.first.yesBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Вы вышли...", Toast.LENGTH_SHORT).show()
            updateQuestion(listQuestionModel)
            findNavController().navigate(R.id.navigation_home)

            dialogEx.second.dismiss()
        }
        dialogEx.first.noBtn.setOnClickListener {
            Toast.makeText(requireContext(), "...", Toast.LENGTH_SHORT).show()
            dialogEx.second.dismiss()
        }
    }
}