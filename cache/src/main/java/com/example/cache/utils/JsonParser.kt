package com.example.cache.utils

import java.lang.reflect.Type

interface JsonParser {

    fun <T> fromJson(json: String, type: Type): T?      // Get Json data as String and parse it to kotlin data class to show in app UI
    fun <T> toJson(obj: T, type: Type): String?         // Get data from kotlin data class and parse it to Json as String
}