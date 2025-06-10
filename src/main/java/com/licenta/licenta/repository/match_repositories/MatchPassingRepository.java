package com.licenta.licenta.repository.match_repositories;

import com.licenta.licenta.model.match_entities.MatchPassingWithOpponent;
import com.licenta.licenta.repository.MatchStatsRepository;

public interface MatchPassingRepository extends MatchStatsRepository<MatchPassingWithOpponent, Long> {
  /*  List<MatchPassingWithOpponent> findByPlayerIgnoreCase(String player);
    List<MatchPassingWithOpponent> findByPlayerIgnoreCaseAndOpponentIgnoreCase(String player, String opponent);
    List<MatchPassingWithOpponent> findByPlayerIgnoreCaseAndMatchId(String player, Integer matchId);*/
}