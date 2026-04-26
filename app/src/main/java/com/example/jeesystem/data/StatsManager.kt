package com.example.jeesystem.data

import android.content.Context

class StatsManager(context: Context) {

    private val prefs = context.getSharedPreferences("stats", Context.MODE_PRIVATE)

    fun getXP() = prefs.getInt("xp", 0)
    fun getLevel() = getXP() / 100

    fun getTotal() = prefs.getInt("total", 0)
    fun getCorrect() = prefs.getInt("correct", 0)
    fun getStreak() = prefs.getInt("streak", 0)

    fun getAccuracy(): Int {
        val t = getTotal()
        return if (t == 0) 0 else (getCorrect() * 100) / t
    }

    fun addResult(correct: Boolean, xp: Int) {
        val editor = prefs.edit()

        editor.putInt("total", getTotal() + 1)

        if (correct) {
            editor.putInt("correct", getCorrect() + 1)
            editor.putInt("streak", getStreak() + 1)
        } else {
            editor.putInt("streak", 0)
        }

        editor.putInt("xp", getXP() + xp)

        editor.apply()
    }
}
