package io.moonbucks.api.dto.mapper

import io.moonbucks.api.dto.member.MemberDto
import io.moonbucks.api.entity.member.IndividualMember
import io.moonbucks.api.entity.member.Member
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface MemberMapper {

    fun toMemberDto(member: Member) : MemberDto
    fun toIndividualMember(memberDto: MemberDto) : IndividualMember
}