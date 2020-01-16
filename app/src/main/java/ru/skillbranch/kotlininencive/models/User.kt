package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    var id: String,
    var firstname: String?,
    var lastname: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false

) {
    var introBit: String


    constructor(id: String, firstname: String?, lastname: String?) : this(
        id = id,
        firstname = firstname,
        lastname = lastname,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe $id")

    init {
        introBit = getIntro()

//        println(
//            "Hello ${if (lastname == "Wick") "His name is $firstname $lastname \n${introBit}"
//            else "And his name is $firstname $lastname!!!\n\n"}"
//        )
    }


    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User {
            lastId++

//            val parts: List<String>? = fullName?.split(" ")
////
////            val firstname: String? = parts?.getOrNull(0)
////            val lastname: String? = parts?.getOrNull(1)

            val (firstname, lastname) = Utils.parseFullname(fullName)

            return User(id = "$lastId", firstname = firstname, lastname = lastname)
        }
    }

    private fun getIntro() = """ 
        tu tu tuuu!!!
        tu tu tuuu...        

    """.trimIndent()

    fun printMe() =
        println(
            """ 
            id: $id
            firstname$firstname
            lastname:$lastname
            avatar: $avatar
            rating: $rating
            respect: $respect
            lastVisit$lastVisit
            isOnline:$isOnline
        """.trimIndent()
        )
}