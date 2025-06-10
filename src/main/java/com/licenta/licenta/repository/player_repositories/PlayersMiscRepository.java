package com.licenta.licenta.repository.player_repositories;

import com.licenta.licenta.model.player_entities.PlayersMisc;
import com.licenta.licenta.repository.PlayersStatsRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersMiscRepository extends PlayersStatsRepository<PlayersMisc, Long> {
}