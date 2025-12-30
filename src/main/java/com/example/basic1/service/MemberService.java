package com.example.basic1.service;

import com.example.basic1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

public class MemberService {

    private final MemberRepository memberRepository;
}
