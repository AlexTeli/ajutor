package com.licenta.licenta.repository.player_repositories;

import com.licenta.licenta.model.player_entities.PlayersPassingTypes;
import com.licenta.licenta.repository.PlayersStatsRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersPassingTypesRepository extends PlayersStatsRepository<PlayersPassingTypes, Long> {
}