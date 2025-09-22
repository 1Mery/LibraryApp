package com.example.libraryNew.controller;

import com.example.libraryNew.dto.request.member.CreateMemberRequest;
import com.example.libraryNew.dto.request.member.UpdateMemberRequest;
import com.example.libraryNew.dto.response.member.CreatedMemberResponse;
import com.example.libraryNew.dto.response.member.DeletedMemberResponse;
import com.example.libraryNew.dto.response.member.GetListMemberResponse;
import com.example.libraryNew.dto.response.member.UpdatedMemberResponse;
import com.example.libraryNew.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/list")
    public List<GetListMemberResponse> getListMember(@RequestParam(required = false)String name){
        if(name==null){
            return memberService.getListMember();
        }
        return memberService.getListMember();
    }

    @PostMapping("/create")
    public CreatedMemberResponse createMember(@RequestBody CreateMemberRequest createMemberRequest){
        return memberService.createMember(createMemberRequest);
    }

    @PatchMapping("/update/{id}")
    public UpdatedMemberResponse updateMember(@PathVariable int id,
                                              @RequestBody UpdateMemberRequest updateMemberRequest){
        return memberService.updateMember(id,updateMemberRequest);
    }

    @DeleteMapping("/delete/{id}")
    public DeletedMemberResponse deleteMember(@PathVariable int id){
        return memberService.deleteMember(id);
    }

}
