package com.golfclub.controllers;

import com.golfclub.models.Member;
import com.golfclub.models.Tournament;
import com.golfclub.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public Optional<Tournament> getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @GetMapping("/search")
    public List<Tournament> searchTournaments(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String location
    ) {
        if (startDate != null) return tournamentService.searchByStartDate(LocalDate.parse(startDate));
        if (location != null) return tournamentService.searchByLocation(location);
        return tournamentService.getAllTournaments();
    }

    @PostMapping("/{tournamentId}/add-member/{memberId}")
    public Tournament addMemberToTournament(
            @PathVariable Long tournamentId,
            @PathVariable Long memberId
    ) {
        return tournamentService.addMemberToTournament(tournamentId, memberId);
    }

    @GetMapping("/{tournamentId}/members")
    public List<Member> getTournamentMembers(@PathVariable Long tournamentId) {
        return tournamentService.getMembersInTournament(tournamentId);
    }
}
