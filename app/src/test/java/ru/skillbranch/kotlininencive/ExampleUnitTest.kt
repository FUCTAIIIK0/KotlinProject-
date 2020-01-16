package ru.skillbranch.devintensive

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.kotlininencive.extensions.TimeUnits
import ru.skillbranch.kotlininencive.extensions.add
import ru.skillbranch.kotlininencive.extensions.format
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_Instance() {
        val user1 = User("1")
        val user2 = User("2", "Jon", "Wick")
        val user3 = User(
            "3", "Jon", "Silverhand",
            null, lastVisit = Date(), isOnline = true
        )

        //user1.printMe()
        //user2.printMe()
        //user3.printMe()
    }

    @Test
    fun test_Factory() {
        val user1 = User.Factory.makeUser("Ayrton Senna")
//        val user2 = User.makeUser("John Wick")
//        val user3 = User.makeUser("Duke Nukem")
//        val user4 = User.makeUser("")
        val user4 = user1.copy(id = "3", lastname = "Osterman", lastVisit = Date())

        println("$user1 \n $user4")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Osterman")

        fun getUserInfo() = user
        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName $lastName")
        println("${user.component1()}, ${user.component2()} ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Osterman")
        //val user2 = user.copy(id = "2",lastVisit = Date())
        val user2 = user.copy()

        if (user.equals(user2)) {
            println(" equals data and hash\n ${user.hashCode()}\n $user\n ${user2.hashCode()}\n $user2\n")
        } else {
            println(" not equals data and hash\n ${user.hashCode()}\n $user\n ${user2.hashCode()}\n $user2\n")
        }

        if (user === user2) {
            println(" equals links\n ${user.hashCode()}\n $user\n ${user2.hashCode()}\n $user2\n")
        } else {
            println(" not equals links\n ${user.hashCode()}\n $user\n ${user2.hashCode()}\n $user2\n")
        }

        println(
            """
            
        """.trimIndent()
        )

    }

    @Test
    fun test_formatdate() {
        val user1 = User.makeUser("Ayrton Senna")
        val user2 = user1.copy(
            id = "1", firstname = "John", lastname = "Wick", lastVisit = Date()
        )
        val user3 = user2.copy(
            id = "1",
            firstname = "John",
            lastname = "Wick",
            lastVisit = Date().add(-2, TimeUnits.MINUTE)
        )
        val user4 = user3.copy(
            id = "2",
            firstname = "Edward",
            lastVisit = Date().add(+2, TimeUnits.HOUR),
            isOnline = true
        )

        println(
            """
            ${user1.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent()
        )


    }

    @Test
    fun test_user_toUserView() {
        val user = User.makeUser("Jhon Doy")
        val user1 = user.copy(lastVisit = Date(), isOnline = false)
        val date: Date? = user1.lastVisit

    }

    @Test
    fun test_Date_humanizeDiff() {
        val user = User.makeUser("Jhon Doy")
        val user1 = user.copy(lastVisit = Date(), isOnline = false)
        val date: Date? = user1.lastVisit

    }
}
