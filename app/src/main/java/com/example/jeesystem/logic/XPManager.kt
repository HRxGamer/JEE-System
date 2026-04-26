package com.example.jeesystem.logic

object XPManager {

    fun getXP(diff: String, type: String, level: Int): Int {

        var base = when(diff) {
            "easy" -> 10
            "medium" -> 20
            "hard" -> 30
            else -> 5
        }

        if (type == "advanced") base += 10

        val scaled = base - (level * 2)

        return if (scaled < 5) 5 else scaled
    }
}
