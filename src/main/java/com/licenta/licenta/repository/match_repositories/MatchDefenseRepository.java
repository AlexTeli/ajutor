package com.licenta.licenta.repository.match_repositories;

import com.licenta.licenta.model.match_entities.MatchDefenseWithOpponent;
import com.licenta.licenta.repository.MatchStatsRepository;


public interface MatchDefenseRepository extends MatchStatsRepository<MatchDefenseWithOpponent, Long> {
/*    List<MatchDefenseWithOpponent> findByPlayerIgnoreCase(String player);
    List<MatchDefenseWithOpponent> findByPlayerIgnoreCaseAndOpponentIgnoreCase(String player, String opponent);
    List<MatchDefenseWithOpponent> findByPlayerIgnoreCaseAndMatchId(String player, Integer matchId);*/
}