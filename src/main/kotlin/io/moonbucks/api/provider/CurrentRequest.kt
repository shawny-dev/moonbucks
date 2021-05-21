package io.moonbucks.api.provider

import io.moonbucks.api.entity.member.Member
import org.springframework.web.context.request.RequestAttributes
import org.springframework.web.context.request.RequestContextHolder

private const val currentUserKey = "current_user"

fun currentUser(): Member {
    return RequestContextHolder.getRequestAttributes()!!.getAttribute(currentUserKey, RequestAttributes.SCOPE_REQUEST) as Member
}

fun setCurrentUser(user: Member) {
    RequestContextHolder.getRequestAttributes()?.setAttribute(currentUserKey, user, RequestAttributes.SCOPE_REQUEST)
}
