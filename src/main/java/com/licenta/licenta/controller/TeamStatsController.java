package com.licenta.licenta.controller;

import com.licenta.licenta.dto.TeamStatsDTO;
import com.licenta.licenta.service.TeamStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamStatsController {

    private final TeamStatsService service;

    private static final Set<String> VALID_TEAM_STATS_TYPES = Set.of(
            "shooting", "misc", "goalsCreation", "goals-creation", "defense",
            "possession", "passing", "passType", "pass-type", "summary"
    );

    @GetMapping("/stats")
    public ResponseEntity<?> getAllTeamStats(
            @RequestParam(required = false) String statsType) {

        Set<String> statsTypes = parseStatsTypes(statsType);
        if (statsTypes == null) {
            return ResponseEntity.badRequest().body("Invalid stats types. Valid types: " + VALID_TEAM_STATS_TYPES);
        }

        TeamStatsDTO dto = service.getAllTeamStats(statsTypes);

        return dto == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(dto);
    }

    @GetMapping("/{squad}/stats")
    public ResponseEntity<?> getTeamStatsBySquad(
            @PathVariable String squad,
            @RequestParam(required = false) String statsType) {

        Set<String> statsTypes = parseStatsTypes(statsType);
        if (statsTypes == null) {
            return ResponseEntity.badRequest().body("Invalid stats types. Valid types: " + VALID_TEAM_STATS_TYPES);
        }

        TeamStatsDTO dto = service.getTeamStatsBySquad(squad, statsTypes);

        return dto == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(dto);
    }

    private Set<String> parseStatsTypes(String statsType) {
        if (statsType == null || statsType.trim().isEmpty()) {
            return null; // Return all stats
        }

        Set<String> statsTypes = Arrays.stream(statsType.split(","))
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        // Validate
        boolean allValid = statsTypes.stream().allMatch(VALID_TEAM_STATS_TYPES::contains);
        return allValid ? statsTypes : null;
    }
}