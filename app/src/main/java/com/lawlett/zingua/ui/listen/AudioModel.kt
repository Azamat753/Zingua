package com.lawlett.zingua.ui.listen

import com.lawlett.zingua.ui.grammar.QuestionModel
import java.io.Serializable

data class AudioModel (
    val nameTheme :String,
    val listQuestionModels: ArrayList<QuestionModel>
) :Serializable


