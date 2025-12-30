package com.example.basic1.service;

import com.example.basic1.dto.*;
import com.example.basic1.entity.Member;
import com.example.basic1.repository.MemberRepository;
import lombok.Getter;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor

public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberCreateResponse save(MemberCreateRequest request) {
        Member member = new Member(request.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberCreateResponse(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getCreatedAt(),
                savedMember.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<MemberGetResponse> findAll(){
        List<Member> members = memberRepository.findAll();
        List<MemberGetResponse> dtos = new ArrayList<>();
        for (Member member : members) {
            MemberGetResponse response = new MemberGetResponse(
                    member.getId(),
                    member.getName(),
                    member.getModifiedAt(),
                    member.getCreatedAt()
            );
            dtos.add(response);
            
        }
        return dtos;
    }


    @Transactional(readOnly = true)
    public MemberGetResponse findOne(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버입니다.")
        );
        return new MemberGetResponse(
                member.getId(),
                member.getName(),
                member.getModifiedAt(),
                member.getCreatedAt()
        );
    }

    @Transactional
    public MemberUpdateResponse update(Long memberId, MemberUpdateRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버입니다.")

        );
        member.update(request.getName());
        return new MemberUpdateResponse(
                member.getId(),
                member.getName(),
                member.getModifiedAt(),
                member.getCreatedAt()

        );
    }

    @Transactional
    public void delete(long membersId) {
        boolean existence = memberRepository.existsById(membersId);

        if(!existence){
            throw new IllegalArgumentException(" 없는 멤버입니다.");
        }

        memberRepository.deleteById(membersId);
    }
}