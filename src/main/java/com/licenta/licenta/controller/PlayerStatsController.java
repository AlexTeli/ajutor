package com.licenta.licenta.controller;

import com.licenta.licenta.dto.CompleteStatsDTO;
import com.licenta.licenta.dto.GeneralStatsDTO;
import com.licenta.licenta.service.PlayerStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerStatsController {

    private final PlayerStatsService service;

    private static final Set<String> VALID_STATS_TYPES = Set.of(
            "possession", "defense", "passing", "summary", "misc", "passingTypes", "passing-types",
            "shooting", "time", "goalsCreation", "goals-creation"
    );

    // === MATCH STATS ENDPOINTS ===

    @GetMapping("/{player}/matches")
    public ResponseEntity<?> getMatchStats(
            @PathVariable String player,
            @RequestParam(required = false) String opponent,
            @RequestParam(required = false) Integer matchId,
            @RequestParam(required = false) String statsType) {

        if (opponent != null && matchId != null) {
            return ResponseEntity.badRequest().body("Cannot specify both opponent and matchId");
        }

        Set<String> statsTypes = parseStatsTypes(statsType);
        if (statsTypes == null) {
            return ResponseEntity.badRequest().body("Invalid stats types. Valid types: " + VALID_STATS_TYPES);
        }

        CompleteStatsDTO dto;
        if (opponent != null) {
            dto = service.getMatchStatsByPlayerAndOpponent(player, opponent, statsTypes);
        } else if (matchId != null) {
            dto = service.getMatchStatsByPlayerAndMatchId(player, matchId, statsTypes);
        } else {
            dto = service.getMatchStatsByPlayer(player, statsTypes);
        }

        return dto == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(dto);
    }

    // === GENERAL STATS ENDPOINTS ===

    @GetMapping("/{player}/stats")
    public ResponseEntity<?> getGeneralStats(
            @PathVariable String player,
            @RequestParam(required = false) String squad,
            @RequestParam(required = false) String nation,
            @RequestParam(required = false) String statsType) {

        if (squad != null && nation != null) {
            return ResponseEntity.badRequest().body("Cannot specify both squad and nation");
        }

        Set<String> statsTypes = parseStatsTypes(statsType);
        if (statsTypes == null) {
            return ResponseEntity.badRequest().body("Invalid stats types. Valid types: " + VALID_STATS_TYPES);
        }

        GeneralStatsDTO dto;
        if (squad != null) {
            dto = service.getGeneralStatsByPlayerAndSquad(player, squad, statsTypes);
        } else if (nation != null) {
            dto = service.getGeneralStatsByPlayerAndNation(player, nation, statsTypes);
        } else {
            dto = service.getGeneralStatsByPlayer(player, statsTypes);
        }

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
        boolean allValid = statsTypes.stream().allMatch(VALID_STATS_TYPES::contains);
        return allValid ? statsTypes : null;
    }
}