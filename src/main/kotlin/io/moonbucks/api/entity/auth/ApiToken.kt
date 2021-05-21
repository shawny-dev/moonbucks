package io.moonbucks.api.entity.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "api_tokens")
class ApiToken(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
    val accessKey: String,
    val secretKey: String,

    var label: String?,
    var scopes: String?,
    var trustedIpList: String?,
    var expireAt: Date?,
    var datetime: Date?,

    val memberId: Long,
    // TODO - add oauthAccessToken

    var deletedAt: Date?,
    @CreatedDate val createdAt: Date,
    @LastModifiedDate var updatedAt: Date,
) {
    fun hasExpired(): Boolean {
        return expireAt != null && expireAt!!.before(Date())
    }

    fun generateJwt(): String {
        return JWT.create()
            .withClaim("access_key", accessKey)
            .withClaim("nonce", Date().time)
            .sign(Algorithm.HMAC256(secretKey))
    }
}
