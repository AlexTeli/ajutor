package com.licenta.licenta.dto;

import com.licenta.licenta.model.match_entities.*;

import java.util.List;

public record CompleteStatsDTO(
        List<MatchPossessionWithOpponent> possession,
        List<MatchDefenseWithOpponent> defense,
        List<MatchPassingWithOpponent> passing,
        List<MatchSummaryWithOpponent> summary,
        List<MatchMiscWithOpponent> misc,
        List<MatchPassingTypesWithOpponent> passingTypes
) {}