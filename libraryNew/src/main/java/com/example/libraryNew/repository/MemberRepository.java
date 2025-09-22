package com.example.libraryNew.repository;

import com.example.libraryNew.entity.Member;
import com.example.libraryNew.enums.MemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Integer> {
    @Query("SELECT m FROM Member m LEFT JOIN FETCH m.punish WHERE m.id = :id")
    Optional<Member> findByIdWithPunish(@Param("id") int id);
    Optional<Member> findTop1ByEmail(String email);
    List<Member> findByMemberStatusAndMail(MemberStatus memberStatus, String email);

}
