package ru.skillbranch.devintensive

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.models.User
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
    fun testInstance() {
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
    fun testFactory() {
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

    }
}
