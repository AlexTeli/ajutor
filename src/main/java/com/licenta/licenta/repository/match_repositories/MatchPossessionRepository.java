package com.licenta.licenta.repository.match_repositories;

import com.licenta.licenta.model.match_entities.MatchPossessionWithOpponent;
import com.licenta.licenta.repository.MatchStatsRepository;

public interface MatchPossessionRepository extends MatchStatsRepository<MatchPossessionWithOpponent, Long> {
  /*  List<MatchPossessionWithOpponent> findByPlayerIgnoreCase(String player);
    List<MatchPossessionWithOpponent> findByPlayerIgnoreCaseAndOpponentIgnoreCase(String player, String opponent);
    List<MatchPossessionWithOpponent> findByPlayerIgnoreCaseAndMatchId(String player, Integer matchId);*/
}