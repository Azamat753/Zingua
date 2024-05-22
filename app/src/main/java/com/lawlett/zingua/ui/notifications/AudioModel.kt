package com.lawlett.zingua.ui.notifications

import java.io.Serializable

data class AudioModel (
    val nameTheme :String,
    val audioQuestionModel: ArrayList<AudioModelList>
) :Serializable

data class AudioModelList(
    val question : String,
    val answer : ArrayList<AnswerModelAudio>
):Serializable
data class AnswerModelAudio(
    val text: String,
    val isCorrect: Boolean
) :Serializable
