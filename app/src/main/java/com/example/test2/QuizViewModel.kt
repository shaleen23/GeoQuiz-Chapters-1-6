package com.example.test2

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"


class QuizViewModel : ViewModel() {

    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }

    var currentIndex = 0
    var isCheater = false

    private val questionBank = listOf(
        Question(R.string.question_australia, false),
        Question(R.string.question_river, false),
        Question(R.string.question_americaRiver, true),
        Question(R.string.question_lake, false),
        Question(R.string.question_oceans, true),
        Question(R.string.question_canal, true)
    )

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}