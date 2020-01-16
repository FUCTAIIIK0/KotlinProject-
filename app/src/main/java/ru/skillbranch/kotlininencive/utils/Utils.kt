package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullname(fullName: String?): Pair<String?, String?> {
        //TODO FIX parse wth "" " "
        val parts: List<String>? = fullName?.split(" ")

        val firstname: String? = parts?.getOrNull(0)
        val lastname: String? = parts?.getOrNull(1)
        //return Pair(firstname,lastname)
        return firstname to lastname
    }
}