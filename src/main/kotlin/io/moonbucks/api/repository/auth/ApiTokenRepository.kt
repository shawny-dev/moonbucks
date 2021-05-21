package io.moonbucks.api.repository.auth

import io.moonbucks.api.entity.auth.ApiToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ApiTokenRepository : CrudRepository<ApiToken, Long> {
    fun findByAccessKey(accessKey: String): ApiToken?
}
