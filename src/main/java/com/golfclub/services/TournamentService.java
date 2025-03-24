package com.golfclub.services;

import com.golfclub.models.Member;
import com.golfclub.models.Tournament;
import com.golfclub.repositories.MemberRepository;
import com.golfclub.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> searchByStartDate(LocalDate date) {
        return tournamentRepository.findByStartDate(date);
    }

    public List<Tournament> searchByLocation(String location) {
        return tournamentRepository.findByLocationContainingIgnoreCase(location);
    }

    public Tournament addMemberToTournament(Long tournamentId, Long memberId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();

        tournament.getParticipants().add(member);
        return tournamentRepository.save(tournament);
    }

    public List<Member> getMembersInTournament(Long tournamentId) {
        return tournamentRepository.findById(tournamentId)
                .map(Tournament::getParticipants)
                .map(List::copyOf)
                .orElseThrow();
    }
}
