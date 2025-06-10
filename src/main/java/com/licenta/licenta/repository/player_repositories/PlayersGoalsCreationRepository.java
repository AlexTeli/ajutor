package com.licenta.licenta.repository.player_repositories;

import com.licenta.licenta.model.player_entities.PlayersGoalsCreation;
import com.licenta.licenta.repository.PlayersStatsRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersGoalsCreationRepository extends PlayersStatsRepository<PlayersGoalsCreation, Long> {
}