package com.licenta.licenta.service;

import com.licenta.licenta.dto.CompleteStatsDTO;
import com.licenta.licenta.dto.GeneralStatsDTO;
import com.licenta.licenta.repository.MatchStatsRepository;
import com.licenta.licenta.repository.PlayersStatsRepository;
import com.licenta.licenta.repository.match_repositories.*;
import com.licenta.licenta.repository.player_repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PlayerStatsService {

    // Match-specific repositories
    private final MatchPossessionRepository matchPossRepo;
    private final MatchDefenseRepository matchDefRepo;
    private final MatchPassingRepository matchPassRepo;
    private final MatchSummaryRepository matchSummaryRepo;
    private final MatchMiscRepository matchMiscRepo;
    private final MatchPassingTypesRepository matchPassingTypesRepo;

    // General stats repositories
    private final PlayersPossessionRepository playersPossessionRepo;
    private final PlayersDefenseRepository playersDefenseRepo;
    private final PlayersPassingRepository playersPassingRepo;
    private final PlayersSummaryRepository playersSummaryRepo;
    private final PlayersMiscRepository playersMiscRepo;
    private final PlayersPassingTypesRepository playersPassingTypesRepo;
    private final PlayersShootingRepository playersShootingRepo;
    private final PlayersTimeRepository playersTimeRepo;
    private final PlayersGoalsCreationRepository playersGoalsCreationRepo;

    // === MATCH STATS METHODS ===

    public CompleteStatsDTO getMatchStatsByPlayer(String player, Set<String> statsTypes) {
        return getMatchStats(player, null, null, statsTypes);
    }

    public CompleteStatsDTO getMatchStatsByPlayerAndOpponent(String player, String opponent, Set<String> statsTypes) {
        return getMatchStats(player, opponent, null, statsTypes);
    }

    public CompleteStatsDTO getMatchStatsByPlayerAndMatchId(String player, Integer matchId, Set<String> statsTypes) {
        return getMatchStats(player, null, matchId, statsTypes);
    }

    private CompleteStatsDTO getMatchStats(String player, String opponent, Integer matchId, Set<String> statsTypes) {
        boolean includeAll = (statsTypes == null || statsTypes.isEmpty());

        return new CompleteStatsDTO(
                (includeAll || statsTypes.contains("possession")) ?
                        getMatchStatsData(matchPossRepo, player, opponent, matchId) : null,
                (includeAll || statsTypes.contains("defense")) ?
                        getMatchStatsData(matchDefRepo, player, opponent, matchId) : null,
                (includeAll || statsTypes.contains("passing")) ?
                        getMatchStatsData(matchPassRepo, player, opponent, matchId) : null,
                (includeAll || statsTypes.contains("summary")) ?
                        getMatchStatsData(matchSummaryRepo, player, opponent, matchId) : null,
                (includeAll || statsTypes.contains("misc")) ?
                        getMatchStatsData(matchMiscRepo, player, opponent, matchId) : null,
                (includeAll || statsTypes.contains("passingTypes") || statsTypes.contains("passing-types")) ?
                        getMatchStatsData(matchPassingTypesRepo, player, opponent, matchId) : null
        );
    }

    private <T> List<T> getMatchStatsData(MatchStatsRepository<T, Long> repo,
                                          String player, String opponent, Integer matchId) {
        if (matchId != null) {
            return repo.findByPlayerIgnoreCaseAndMatchId(player, matchId);
        } else if (opponent != null) {
            return repo.findByPlayerIgnoreCaseAndOpponentIgnoreCase(player, opponent);
        } else {
            return repo.findByPlayerIgnoreCase(player);
        }
    }

    // === GENERAL STATS METHODS ===

    public GeneralStatsDTO getGeneralStatsByPlayer(String player, Set<String> statsTypes) {
        return getGeneralStats(player, null, null, statsTypes);
    }

    public GeneralStatsDTO getGeneralStatsByPlayerAndSquad(String player, String squad, Set<String> statsTypes) {
        return getGeneralStats(player, squad, null, statsTypes);
    }

    public GeneralStatsDTO getGeneralStatsByPlayerAndNation(String player, String nation, Set<String> statsTypes) {
        return getGeneralStats(player, null, nation, statsTypes);
    }

    private GeneralStatsDTO getGeneralStats(String player, String squad, String nation, Set<String> statsTypes) {
        boolean includeAll = (statsTypes == null || statsTypes.isEmpty());

        return new GeneralStatsDTO(
                (includeAll || statsTypes.contains("possession")) ?
                        getGeneralStatsData(playersPossessionRepo, player, squad, nation) : null,
                (includeAll || statsTypes.contains("defense")) ?
                        getGeneralStatsData(playersDefenseRepo, player, squad, nation) : null,
                (includeAll || statsTypes.contains("passing")) ?
                        getGeneralStatsData(playersPassingRepo, player, squad, nation) : null,
                (includeAll || statsTypes.contains("summary")) ?
                        getGeneralStatsData(playersSummaryRepo, player, squad, nation) : null,
                (includeAll || statsTypes.contains("misc")) ?
                        getGeneralStatsData(playersMiscRepo, player, squad, nation) : null,
                (includeAll || statsTypes.contains("passingTypes") || statsTypes.contains("passing-types")) ?
                        getGeneralStatsData(playersPassingTypesRepo, player, squad, nation) : null,
                (includeAll || statsTypes.contains("shooting")) ?
                        getGeneralStatsData(playersShootingRepo, player, squad, nation) : null,
                (includeAll || statsTypes.contains("time")) ?
                        getGeneralStatsData(playersTimeRepo, player, squad, nation) : null,
                (includeAll || statsTypes.contains("goalsCreation") || statsTypes.contains("goals-creation")) ?
                        getGeneralStatsData(playersGoalsCreationRepo, player, squad, nation) : null
        );
    }

    private <T> List<T> getGeneralStatsData(PlayersStatsRepository<T, Long> repo,
                                            String player, String squad, String nation) {
        if (squad != null) {
            return repo.findByPlayerIgnoreCaseAndSquadIgnoreCase(player, squad);
        } else if (nation != null) {
            return repo.findByPlayerIgnoreCaseAndNationIgnoreCase(player, nation);
        } else {
            return repo.findByPlayerIgnoreCase(player);
        }
    }
}