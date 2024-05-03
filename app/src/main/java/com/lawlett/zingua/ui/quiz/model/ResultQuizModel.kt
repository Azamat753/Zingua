package com.lawlett.zingua.ui.quiz.model

import java.io.Serializable

data  class ResultQuizModel  (
    val allQuestion: String,
    val rightAnswer : String,
    val wrongAnswer : String,
    val time : String
): Serializable
