package io.moonbucks.api.service.member

import io.moonbucks.api.dto.mapper.MemberMapper
import io.moonbucks.api.dto.member.MemberDto
import io.moonbucks.api.entity.member.Member
import io.moonbucks.api.exception.NotFoundRecordException
import io.moonbucks.api.repository.member.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MemberService {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var memberMapper: MemberMapper

    fun getMember(id: Long): MemberDto {
        val member: Member? = memberRepository.findByIdOrNull(id)
            ?.let { it }
            ?: throw NotFoundRecordException()

        return memberMapper.toMemberDto(member)
    }

    fun setMember(memberDto: MemberDto): Member {
        return memberRepository.save(memberMapper.toIndividualMember(memberDto))
    }
}