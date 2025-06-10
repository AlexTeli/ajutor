package com.licenta.licenta.repository.player_repositories;

import com.licenta.licenta.model.player_entities.PlayersPassing;
import com.licenta.licenta.repository.PlayersStatsRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersPassingRepository extends PlayersStatsRepository<PlayersPassing, Long> {
}