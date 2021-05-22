package io.moonbucks.api.repository.member

import io.moonbucks.api.entity.member.Member
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

// DAO
@Repository
interface MemberRepository : CrudRepository<Member, Long> {
    fun findByUuid(uuid: String) : Member?
}
