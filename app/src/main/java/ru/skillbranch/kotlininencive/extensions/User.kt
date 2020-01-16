package ru.skillbranch.kotlininencive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.kotlininencive.models.UserView
import java.util.*


fun User.toUserView(): UserView {
    val nickName = "IG"
    val initials = "IG"
    val status =
        if (lastVisit == null) "Ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"


    return UserView(
        id,
        fullName = "$firstname $lastname",
        avatar = avatar,
        nickName = nickName,
        initials = initials,
        status = status
    )
}

private fun Date.humanizeDiff(date: Date = Date()): String {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

