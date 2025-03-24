package com.golfclub.services;

import com.golfclub.models.Member;
import com.golfclub.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> searchByName(String name) {
        return memberRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Member> searchByPhone(String phone) {
        return memberRepository.findByPhone(phone);
    }

    public List<Member> searchByStartDate(LocalDate date) {
        return memberRepository.findByStartDate(date);
    }
}
