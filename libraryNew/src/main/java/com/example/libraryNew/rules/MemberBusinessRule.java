package com.example.libraryNew.rules;

import com.example.libraryNew.core.exceptions.type.BusinessException;
import com.example.libraryNew.entity.Member;
import com.example.libraryNew.enums.MemberStatus;
import com.example.libraryNew.repository.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class MemberBusinessRule {

    private final MemberRepository memberRepository;

    public MemberBusinessRule(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member memberShouldExistWithGivenId(int id){
        return memberRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Member with" + id + "not found"));
    }

    public void memberEmailShouldBeUnique(String email){
        Member member = memberRepository.findTop1ByEmail(email)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        if (member != null) {
            throw new BusinessException("Member with email" + email + "already exists");
        }
    }

    public void memberShouldBeActive(MemberStatus memberStatus) {
        if (memberStatus != MemberStatus.ACTIVE) {
            throw new BusinessException("Member is not active");
        }
    }

    /*/public void memberShouldNotHaveUnpaidPunish(Member member) {
        for (Punish punish : member.getPunish()) {
            if (!punish.isPaid()) {
                throw new BusinessException("Member has unpaid punish");
            }
        }
    }*/

    /*/public void memberShouldNotExceedBorrowLimit(Member member, MemberLevel memberLevel){
          if (member.getBorrow().size() > memberLevel.getMaxBorrow()){

           throw new IllegalStateException("Member has exceeded borrow limit");
            }
        }/*/

}
