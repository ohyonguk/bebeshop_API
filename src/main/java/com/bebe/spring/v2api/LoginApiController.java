package com.bebe.spring.v2api;

import com.bebe.spring.v2Dto.MemberRequestDto;
import com.bebe.spring.v2domain.MemberV2;
import com.bebe.spring.v2repository.member.MemberRepository;
import com.bebe.spring.v2service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class LoginApiController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<MemberV2> Login(@RequestBody MemberRequestDto memberRequestDto){
        MemberV2 member = memberService.loginMember(memberRequestDto);

        return ResponseEntity.ok().body(member);

    }

}
