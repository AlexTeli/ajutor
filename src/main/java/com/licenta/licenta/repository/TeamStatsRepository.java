package com.licenta.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TeamStatsRepository<T, ID> extends JpaRepository<T, ID> {
    List<T> findBySquadIgnoreCase(String squad);
    List<T> findAll();
}