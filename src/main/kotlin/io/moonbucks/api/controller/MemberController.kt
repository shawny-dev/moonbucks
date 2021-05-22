package io.moonbucks.api.controller

import io.moonbucks.api.dto.member.MemberDto
import io.moonbucks.api.entity.member.Member
import io.moonbucks.api.service.member.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class MemberController {

    @Autowired
    lateinit var memberService: MemberService

    @GetMapping("/members/{id}")
    fun getMember(@PathVariable id: Long): MemberDto {
        return memberService.getMember(id)
    }

    @PostMapping("/members")
    fun setMember(@RequestBody memberDto: MemberDto) : Member {
        return memberService.setMember(memberDto)
    }
}