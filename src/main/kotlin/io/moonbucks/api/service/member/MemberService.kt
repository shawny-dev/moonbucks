package io.moonbucks.api.service.member

import io.moonbucks.api.dto.member.MemberDto
import io.moonbucks.api.entity.member.Member
import io.moonbucks.api.repository.member.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MemberService {

    @Autowired
    lateinit var memberRepository: MemberRepository

    fun getMember(uuid: String): MemberDto {
        var member: Member = memberRepository.findByUuid(uuid)
        return MemberDto(member)
    }
}