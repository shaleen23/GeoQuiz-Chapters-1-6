package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.TextView

const val EXTRA_ANSWER_SHOWN = "com.example.myapplication.answer_shown" 
private const val EXTRA_ANSWER_IS_TRUE = "com.example.myapplication.answer_is_true"

class CheatActivity : AppCompatActivity() {
    private lateinit var answerTextView: TextView   // lateinit is used to initialize the variable later
    private lateinit var showAnswerButton: Button   // lateinit is used to initialize the variable later

    private var answerIsTrue = false    // default value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
        title = "Cheat" // set the title of the activity

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)  
        answerTextView = findViewById(R.id.answer_textView)
        showAnswerButton = findViewById(R.id.showAnswer_button)
        showAnswerButton.setOnClickListener {   
            val answerText = when {
                answerIsTrue -> R.string.true_button    // R.string.true_button is the id of the string
                else -> R.string.false_button           // R.string.false_button is the id of the string
            }
            answerTextView.setText(answerText)          // set the text of the TextView
            setAnswerShownResult(true)                  // set the result of the activity
        }
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)   // put the result in the intent
        }
        setResult(Activity.RESULT_OK, data)                // set the result of the activity
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)    // put the answer in the intent
            }
        }
    }
}