package com.example.libraryNew.service;

import com.example.libraryNew.dto.request.member.CreateMemberRequest;
import com.example.libraryNew.dto.request.member.UpdateMemberRequest;
import com.example.libraryNew.dto.response.member.*;
import com.example.libraryNew.entity.*;
import com.example.libraryNew.enums.MemberStatus;
import com.example.libraryNew.mapper.MemberMapper;
import com.example.libraryNew.repository.MemberRepository;
import com.example.libraryNew.rules.MemberBusinessRule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberBusinessRule memberBusinessRule;
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberService(MemberBusinessRule memberBusinessRule, MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberBusinessRule = memberBusinessRule;
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public List<GetListMemberResponse> getListMember(){
       List<Member> members = memberRepository.findAll();
       return memberMapper.toGetListMemberResponse(members);

    }
    // id ile getirme yazılacak

    public CreatedMemberResponse createMember(CreateMemberRequest createMemberRequest){
        memberBusinessRule.memberEmailShouldBeUnique(createMemberRequest.getEmail());

        Member member = memberMapper.toMember(createMemberRequest);
        member=memberRepository.save(member);
        return memberMapper.toCreatedMemberResponse(member);
    }

    public UpdatedMemberResponse updateMember(int id,UpdateMemberRequest updateMemberRequest){
        memberBusinessRule.memberShouldExistWithGivenId(id);
        memberBusinessRule.memberEmailShouldBeUnique(updateMemberRequest.getEmail());

        Member member = memberMapper.toMember(updateMemberRequest);
        member=memberRepository.save(member);
        return memberMapper.toUpdatedMemberResponse(member);
    }

    public DeletedMemberResponse deleteMember(int id){
        Member member=memberBusinessRule.memberShouldExistWithGivenId(id);

        memberRepository.delete(member);
        return memberMapper.toDeletedMemberResponse(member);
    }

    public List<GetListMemberResponse> getListMemberStatus(MemberStatus memberStatus,String email){
        List<Member> members = memberRepository.findByMemberStatusAndEmail(memberStatus,email);

        return memberMapper.toGetListMemberResponse(members);
    }

}
