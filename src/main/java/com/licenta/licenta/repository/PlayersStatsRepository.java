package com.licenta.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface PlayersStatsRepository<T, ID> extends JpaRepository<T, ID> {
    List<T> findByPlayerIgnoreCase(String player);
    List<T> findByPlayerIgnoreCaseAndSquadIgnoreCase(String player, String squad);
    List<T> findByPlayerIgnoreCaseAndNationIgnoreCase(String player, String nation);
    List<T> findBySquadIgnoreCase(String squad);
    List<T> findByNationIgnoreCase(String nation);
    List<T> findByPosIgnoreCase(String position);
}