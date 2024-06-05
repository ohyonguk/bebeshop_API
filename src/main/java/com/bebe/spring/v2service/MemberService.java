package com.bebe.spring.v2service;

import com.bebe.spring.v2Dto.MemberRequestDto;
import com.bebe.spring.v2Dto.MemberSearchDto;
import com.bebe.spring.v2domain.MemberV2;
import com.bebe.spring.v2exception.member.MemberException;
import com.bebe.spring.v2repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * The type Member v 2 service.
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * Member join.
     *
     * @param memberV2 the member v 2
     */
    @Transactional
    public void memberJoin(MemberV2 memberV2){
        MemberV2 existMember = memberRepository.findMemberById(memberV2.getId());
        if(!ObjectUtils.isEmpty(existMember)){
            throw new MemberException("이미 존재하는 id 입니다.");
        }
        memberRepository.save(memberV2);
    }

    /**
     * Find member list.
     *
     * @param memberSearchDto the member search dto
     * @return the list
     */
    public List<MemberSearchDto> findMember(MemberSearchDto memberSearchDto){
        return memberRepository.findMember(memberSearchDto);
    }

    /**
     * The Member delete.
     */
    @Transactional
    public Long memberDelete(String id){
        MemberV2 existMember = memberRepository.findMemberById(id);
        if(ObjectUtils.isEmpty(existMember)){
            throw new MemberException("존재하지 않는 회원입니다.");
        }
        return memberRepository.deleteMember(id);
    }

    public MemberV2 loginMember(MemberRequestDto memberRequestDto) {
        MemberV2 existMember = memberRepository.findMemberById(memberRequestDto.getId());
        if(ObjectUtils.isEmpty(existMember)){
            throw new MemberException("존재하지 않는 회원입니다.");
        }
        if(!memberRequestDto.getPassword().equals(existMember.getPassword())){
            throw new MemberException("비밀번호가 틀렸습니다.");
        }
        return existMember;
    }

    @Transactional
    public void changePassword(MemberRequestDto memberRequestDto) {
        MemberV2 existMember = memberRepository.findMemberById(memberRequestDto.getId());
        if(ObjectUtils.isEmpty(existMember)){
            throw new MemberException("존재하지 않는 회원입니다.");
        }
        if(memberRequestDto.getNowPassword().equals(existMember.getPassword())){
            throw new MemberException("비밀번호가 현재와 같습니다.");
        }
        existMember.setPassword(memberRequestDto.getPassword());
        memberRepository.save(existMember);
    }
}
