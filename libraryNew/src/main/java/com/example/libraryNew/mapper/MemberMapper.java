package com.example.libraryNew.mapper;

import com.example.libraryNew.dto.request.member.CreateMemberRequest;
import com.example.libraryNew.dto.request.member.UpdateMemberRequest;
import com.example.libraryNew.dto.response.member.*;
import com.example.libraryNew.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberMapper {

    public Member toMember(CreateMemberRequest createMemberRequest){
        Member member = new Member();
        member.setName(createMemberRequest.getName());
        member.setEmail(createMemberRequest.getEmail());
        member.setPassword(createMemberRequest.getPassword());
        member.setTel(createMemberRequest.getTel());
        return member;
    }


    public Member toMember(UpdateMemberRequest updateMemberRequest){
        Member member = new Member();
        member.setName(updateMemberRequest.getName());
        member.setEmail(updateMemberRequest.getEmail());
        member.setPassword(updateMemberRequest.getPassword());
        member.setTel(updateMemberRequest.getTel());
        return member;
    }

    public CreatedMemberResponse toCreatedMemberResponse(Member member){
        CreatedMemberResponse createdMemberResponse = new CreatedMemberResponse();
        createdMemberResponse.setId(member.getId());
        createdMemberResponse.setName(member.getName());
        createdMemberResponse.setEmail(member.getEmail());
        createdMemberResponse.setPassword(member.getPassword());
        createdMemberResponse.setTel(member.getTel());
        return createdMemberResponse;
    }

    public UpdatedMemberResponse toUpdatedMemberResponse(Member member){
        UpdatedMemberResponse updatedMemberResponse = new UpdatedMemberResponse();
        updatedMemberResponse.setId(member.getId());
        updatedMemberResponse.setName(member.getName());
        updatedMemberResponse.setEmail(member.getEmail());
        updatedMemberResponse.setPassword(member.getPassword());
        updatedMemberResponse.setTel(member.getTel());
        return updatedMemberResponse;
    }

    public DeletedMemberResponse toDeletedMemberResponse(Member member){
        DeletedMemberResponse deletedMemberResponse = new DeletedMemberResponse();
        deletedMemberResponse.setId(member.getId());
        deletedMemberResponse.setName(member.getName());
        return deletedMemberResponse;
    }

    public List<GetListMemberResponse> toGetListMemberResponse(List<Member> member){
        List<GetListMemberResponse> getListMemberResponse = new ArrayList<>();
        for (Member m : member) {
            GetListMemberResponse getListMemberResponse1 = new GetListMemberResponse();
            getListMemberResponse1.setId(m.getId());
            getListMemberResponse1.setName(m.getName());
            getListMemberResponse1.setMail(m.getEmail());
            getListMemberResponse1.setTel(m.getTel());
            getListMemberResponse1.setMemberLevel(m.getMemberLevel().name());
            getListMemberResponse1.setMemberStatus(m.getMemberStatus().name());
            getListMemberResponse.add(getListMemberResponse1);
        }
        return getListMemberResponse;
    }

}
