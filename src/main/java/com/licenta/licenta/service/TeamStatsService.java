package com.licenta.licenta.service;

import com.licenta.licenta.dto.TeamStatsDTO;
import com.licenta.licenta.repository.TeamStatsRepository;
import com.licenta.licenta.repository.team_repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeamStatsService {

    private final TeamsShootingRepository teamsShootingRepo;
    private final TeamsMiscRepository teamsMiscRepo;
    private final TeamsGoalsCreationRepository teamsGoalsCreationRepo;
    private final TeamsDefenseRepository teamsDefenseRepo;
    private final TeamsPossessionRepository teamsPossessionRepo;
    private final TeamsPassingRepository teamsPassingRepo;
    private final TeamsPassTypeRepository teamsPassTypeRepo;
    private final TeamsSummaryRepository teamsSummaryRepo;

    public TeamStatsDTO getAllTeamStats(Set<String> statsTypes) {
        return getTeamStats(null, statsTypes);
    }

    public TeamStatsDTO getTeamStatsBySquad(String squad, Set<String> statsTypes) {
        return getTeamStats(squad, statsTypes);
    }

    private TeamStatsDTO getTeamStats(String squad, Set<String> statsTypes) {
        boolean includeAll = (statsTypes == null || statsTypes.isEmpty());

        return new TeamStatsDTO(
                (includeAll || statsTypes.contains("shooting")) ?
                        getTeamStatsData(teamsShootingRepo, squad) : null,
                (includeAll || statsTypes.contains("misc")) ?
                        getTeamStatsData(teamsMiscRepo, squad) : null,
                (includeAll || statsTypes.contains("goalsCreation") || statsTypes.contains("goals-creation")) ?
                        getTeamStatsData(teamsGoalsCreationRepo, squad) : null,
                (includeAll || statsTypes.contains("defense")) ?
                        getTeamStatsData(teamsDefenseRepo, squad) : null,
                (includeAll || statsTypes.contains("possession")) ?
                        getTeamStatsData(teamsPossessionRepo, squad) : null,
                (includeAll || statsTypes.contains("passing")) ?
                        getTeamStatsData(teamsPassingRepo, squad) : null,
                (includeAll || statsTypes.contains("passType") || statsTypes.contains("pass-type")) ?
                        getTeamStatsData(teamsPassTypeRepo, squad) : null,
                (includeAll || statsTypes.contains("summary")) ?
                        getTeamStatsData(teamsSummaryRepo, squad) : null
        );
    }

    private <T> List<T> getTeamStatsData(TeamStatsRepository<T, Long> repo, String squad) {
        if (squad != null) {
            return repo.findBySquadIgnoreCase(squad);
        } else {
            return repo.findAll();
        }
    }
}
