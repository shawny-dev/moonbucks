package io.moonbucks.api.dto.mapper

import io.moonbucks.api.dto.member.MemberDto
import io.moonbucks.api.entity.member.Member
import org.mapstruct.Mapper

@Mapper
interface MemberMapper {

    fun toMemberDto(member: Member) : MemberDto
}