package com.scoreboard.model;

import java.time.Instant;

public record Match(String homeTeam, String awayTeam, int homeScore, int awayScore, Instant startTime) {

    public Match {
        startTime = Instant.now();
    }
}
