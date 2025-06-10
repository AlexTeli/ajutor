package com.licenta.licenta.dto;

import com.licenta.licenta.model.player_entities.*;

import java.util.List;

public record GeneralStatsDTO(
        List<PlayersPossession> possession,
        List<PlayersDefense> defense,
        List<PlayersPassing> passing,
        List<PlayersSummary> summary,
        List<PlayersMisc> misc,
        List<PlayersPassingTypes> passingTypes,
        List<PlayersShooting> shooting,
        List<PlayersTime> time,
        List<PlayersGoalsCreation> goalsCreation
) {}