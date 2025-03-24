package com.golfclub.repositories;

import com.golfclub.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByNameContainingIgnoreCase(String name);
    List<Member> findByPhone(String phone);
    List<Member> findByStartDate(LocalDate startDate);
}
