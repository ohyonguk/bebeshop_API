package com.bebe.spring.v2api;

import com.bebe.spring.v2Dto.MemberRequestDto;
import com.bebe.spring.v2Dto.MemberSearchDto;
import com.bebe.spring.v2domain.ApiResponse;
import com.bebe.spring.v2domain.MemberV2;
import com.bebe.spring.v2service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberApiController {
    private final MemberService memberService;

    //회원가입
    @PostMapping(value = "/save")
    public ApiResponse saveMember(@RequestBody @Valid MemberV2 memberV2) {
        ApiResponse apiResponse = ApiResponse.builder().success(true).build();
        try {
            memberService.memberJoin(memberV2);
        }catch (Exception e){
             apiResponse = ApiResponse.builder()
                     .success(false)
                     .message(e.getMessage())
                     .build();
        }
        return apiResponse;
    }
    @PostMapping(value ="/search")
    public ApiResponse findMember(@RequestParam(value = "name",required = false) String name,
                                  @RequestParam(value = "tel",required = false) String tel){
        ApiResponse apiResponse =  null;
        MemberSearchDto memberSearchDto = new MemberSearchDto(name,tel);
        try{
            List<MemberSearchDto> memberList =memberService.findMember(memberSearchDto);
            apiResponse = ApiResponse.builder()
                    .success(true)
                    .body(memberList)
                    .build();
        }catch (Exception e){
            apiResponse = ApiResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
        return apiResponse;
    }
    @PostMapping(value ="/delete")
    public ApiResponse findMember(@RequestParam(value = "id") String id){
        ApiResponse apiResponse =  null;
        try{
            Long cnt = memberService.memberDelete(id);
            apiResponse = ApiResponse.builder()
                    .success(true)
                    .body(cnt)
                    .build();
        }catch (Exception e){
            apiResponse = ApiResponse.builder()
                    .success(false)
                    .message(e.getMessage())
                    .build();
        }
        return apiResponse;
    }
    @PostMapping("/changePassword")
    public ResponseEntity<Void> changePassword(@RequestBody MemberRequestDto memberRequestDto){
        memberService.changePassword(memberRequestDto);

        return ResponseEntity.ok().body(null);
    }





}
