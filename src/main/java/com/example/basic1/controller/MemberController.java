package com.example.basic1.controller;

import com.example.basic1.repository.MemberRepository;
import com.example.basic1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;
}
