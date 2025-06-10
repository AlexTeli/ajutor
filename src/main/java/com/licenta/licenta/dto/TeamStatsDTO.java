package com.licenta.licenta.dto;

import com.licenta.licenta.model.team_entities.*;

import java.util.List;

public record TeamStatsDTO(
        List<TeamsShooting> shooting,
        List<TeamsMisc> misc,
        List<TeamsGoalsCreation> goalsCreation,
        List<TeamsDefense> defense,
        List<TeamsPossession> possession,
        List<TeamsPassing> passing,
        List<TeamsPassType> passType,
        List<TeamsSummary> summary
) {}