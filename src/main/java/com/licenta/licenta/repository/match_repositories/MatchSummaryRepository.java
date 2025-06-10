package com.licenta.licenta.repository.match_repositories;

import com.licenta.licenta.model.match_entities.MatchSummaryWithOpponent;
import com.licenta.licenta.repository.MatchStatsRepository;

public interface MatchSummaryRepository
        extends MatchStatsRepository<MatchSummaryWithOpponent, Long> {}