package com.licenta.licenta.repository.team_repositories;

import com.licenta.licenta.model.team_entities.TeamsPassing;
import com.licenta.licenta.repository.TeamStatsRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsPassingRepository extends TeamStatsRepository<TeamsPassing, Long> {
}
