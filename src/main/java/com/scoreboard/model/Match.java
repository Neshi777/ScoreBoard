package com.scoreboard.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public record Match(String homeTeam, String awayTeam, int homeScore, int awayScore, Instant startTime) {
    private static final Logger logger = LoggerFactory.getLogger(Match.class);

    public Match {
        if (homeTeam == null || awayTeam == null) {
            logger.error("Home team and away team cannot be null");
            throw new NullPointerException("Home team and away team cannot be null");
        }
        if (homeScore < 0 || awayScore < 0) {
            logger.error("Scores cannot be negative: {} - {}", homeScore, awayScore);
            throw new IllegalArgumentException("Scores cannot be negative");
        }
        startTime = Instant.now();
    }
}
