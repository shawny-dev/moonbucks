package io.moonbucks.api.provider

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.SignatureVerificationException
import io.moonbucks.api.exception.*
import io.moonbucks.api.repository.auth.ApiTokenRepository
import io.moonbucks.api.repository.member.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthInterceptor : HandlerInterceptor {

    @Autowired
    lateinit var apiTokenRepository: ApiTokenRepository

    @Autowired
    lateinit var memberRepository: MemberRepository

    override fun preHandle(req: HttpServletRequest, res: HttpServletResponse, handler: Any): Boolean {
        val bearerToken = req.getHeader("Authorization")?.replace("Bearer ", "")
        if (bearerToken.isNullOrEmpty()) {
            throw BadRequest()
        }

        val decodedJwt = JWT.decode(bearerToken)
        if (!decodedJwt.claims.containsKey("access_key")) {
            throw NoAccessKey()
        }

        val apiToken = apiTokenRepository.findByAccessKey(decodedJwt.claims["access_key"]!!.asString()) ?: throw InvalidAccessKey()
        if (apiToken.hasExpired()) {
            throw ExpiredAccessKey()
        }

        try {
            JWT.require(Algorithm.HMAC256(apiToken.secretKey)).build().verify(bearerToken)
        } catch (e: SignatureVerificationException) {
            throw JwtVerification()
        }

        // TODO - nonce, disabled, scope 확인
        setCurrentUser(memberRepository.findById(apiToken.memberId).get())
        return true
    }

}
