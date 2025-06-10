package com.licenta.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean  // Important: prevents Spring from trying to create an instance
public interface MatchStatsRepository<T, ID> extends JpaRepository<T, ID> {
    List<T> findByPlayerIgnoreCase(String player);
    List<T> findByPlayerIgnoreCaseAndOpponentIgnoreCase(String player, String opponent);
    List<T> findByPlayerIgnoreCaseAndMatchId(String player, Integer matchId);
}