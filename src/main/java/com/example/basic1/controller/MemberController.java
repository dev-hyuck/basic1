package com.example.basic1.controller;

import com.example.basic1.dto.*;
import com.example.basic1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberCreateResponse> create(
            @RequestBody MemberCreateRequest request

    ) {
        MemberCreateResponse response = memberService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberGetResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findAll());

    }

    @GetMapping ("/members/{memberId}")
    public ResponseEntity<MemberGetResponse> getOne(
            @PathVariable long memberId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findOne(memberId));
    }

    @PutMapping ("/members/{memberId}")
    public ResponseEntity<MemberUpdateResponse> update(
            @PathVariable Long memberId,
            @RequestBody MemberUpdateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.update(memberId, request));

    }


}
