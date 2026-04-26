package com.example.jeesystem.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonLoader {

    fun load(context: Context): List<Question> {
        val json = context.assets.open("questions.json")
            .bufferedReader().use { it.readText() }

        val type = object : TypeToken<List<Question>>() {}.type
        return Gson().fromJson(json, type)
    }
}
