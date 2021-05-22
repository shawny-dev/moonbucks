package io.moonbucks.api.controller

import io.moonbucks.api.dto.member.MemberDto
import io.moonbucks.api.entity.member.Member
import io.moonbucks.api.service.member.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController {

    @Autowired
    lateinit var memberService: MemberService

    @GetMapping("/api/v1/members/{uuid}")
    fun getMember(@PathVariable uuid: String): MemberDto {
        return memberService.getMember(uuid)
    }
}