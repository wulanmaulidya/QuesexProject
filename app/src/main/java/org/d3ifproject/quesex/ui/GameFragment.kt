package org.d3ifproject.quesex.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.d3ifproject.quesex.R

class GameFragment : Fragment(R.layout.fragment_game) {

        private lateinit var questionTextView: TextView
        private lateinit var optionRadioGroup: RadioGroup
        private lateinit var option1RadioButton: RadioButton
        private lateinit var option2RadioButton: RadioButton
        private lateinit var option3RadioButton: RadioButton
        private lateinit var option4RadioButton: RadioButton
        private lateinit var submitButton: Button
        private lateinit var resultTextView: TextView

        private val questions = arrayOf(
            "Question 1: What is the capital of France?",
            "Question 2: What is the largest planet in our solar system?",
            "Question 3: Who painted the Mona Lisa?",
            "Question 4: What year did World War II end?"
        )

        private val options = arrayOf(
            arrayOf("Paris", "London", "Rome", "Berlin"),
            arrayOf("Jupiter", "Mars", "Earth", "Saturn"),
            arrayOf("Pablo Picasso", "Leonardo da Vinci", "Vincent van Gogh", "Michelangelo"),
            arrayOf("1943", "1944", "1945", "1946")
        )

        private val correctAnswers = arrayOf(0, 2, 1, 2)

        private var currentQuestionIndex = 0
        private var selectedAnswerIndex = -1

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val view = inflater.inflate(R.layout.fragment_game, container, false)

            questionTextView = view.findViewById(R.id.questionTextView)
            optionRadioGroup = view.findViewById(R.id.optionRadioGroup)
            option1RadioButton = view.findViewById(R.id.option1RadioButton)
            option2RadioButton = view.findViewById(R.id.option2RadioButton)
            option3RadioButton = view.findViewById(R.id.option3RadioButton)
            option4RadioButton = view.findViewById(R.id.option4RadioButton)
            submitButton = view.findViewById(R.id.submitButton)
            resultTextView = view.findViewById(R.id.resultTextView)

            submitButton.setOnClickListener {
                checkAnswer()
            }

            displayQuestion()

            return view
        }

        private fun displayQuestion() {
            questionTextView.text = questions[currentQuestionIndex]
            option1RadioButton.text = options[currentQuestionIndex][0]
            option2RadioButton.text = options[currentQuestionIndex][1]
            option3RadioButton.text = options[currentQuestionIndex][2]
            option4RadioButton.text = options[currentQuestionIndex][3]

            optionRadioGroup.clearCheck()
            resultTextView.visibility = View.GONE
        }

        private fun checkAnswer() {
            val selectedOptionId = optionRadioGroup.checkedRadioButtonId

            if (selectedOptionId == -1) {
                // No option selected
                return
            }

            selectedAnswerIndex = when (selectedOptionId) {
                R.id.option1RadioButton -> 0
                R.id.option2RadioButton -> 1
                R.id.option3RadioButton -> 2
                R.id.option4RadioButton -> 3
                else -> -1
            }

            val correctAnswerIndex = correctAnswers[currentQuestionIndex]

            if (selectedAnswerIndex == correctAnswerIndex) {
                resultTextView.text = "Correct answer!"
            } else {
                resultTextView.text = "Wrong answer!"
            }

            resultTextView.visibility = View.VISIBLE
        }
    }
