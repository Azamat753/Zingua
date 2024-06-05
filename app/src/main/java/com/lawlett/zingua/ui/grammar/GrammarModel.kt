package com.lawlett.zingua.ui.grammar

import java.io.Serializable

data class GrammarModel(
    val nameOfTheme: String,
    val ruleOfCompilation: String,
    val examples: String,
    val questionTime: String,
    val negative: String,
    val listQuestionModels: ArrayList<QuestionModel>
) : Serializable

data class  QuestionModel(
    val question: String,
    val answers: ArrayList<AnswerModel>,
    val audio : Int?=null

) :Serializable

data class AnswerModel(
    val text: String,
    val isCorrect: Boolean
) :Serializable