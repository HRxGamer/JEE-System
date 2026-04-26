package com.example.jeesystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.jeesystem.data.*
import com.example.jeesystem.logic.XPManager

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val stats = remember { StatsManager(this) }
            val questions = remember { JsonLoader.load(this) }

            var index by remember { mutableStateOf(0) }
            var answer by remember { mutableStateOf("") }
            var result by remember { mutableStateOf("") }

            val q = questions.getOrNull(index)

            if (q == null) {
                Text("No questions found")
                return@setContent
            }

            Column {

                Text("Level: ${stats.getLevel()} XP: ${stats.getXP()}")

                Text(q.question)

                TextField(
                    value = answer,
                    onValueChange = { answer = it }
                )

                Button(onClick = {

                    val correct = answer.trim().equals(q.answer, true)

                    val xp = if (correct)
                        XPManager.getXP(q.difficulty, q.type, stats.getLevel())
                    else 0

                    stats.addResult(correct, xp)

                    result = if (correct) "Correct +$xp XP" else "Wrong"

                    index++
                    answer = ""

                }) {
                    Text("Submit")
                }

                Text(result)

                Text("Accuracy: ${stats.getAccuracy()}%")
                Text("Streak: ${stats.getStreak()}")

            }
        }
    }
}
