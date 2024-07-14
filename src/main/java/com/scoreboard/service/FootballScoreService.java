package com.scoreboard.service;

import com.scoreboard.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FootballScoreService {
    private static final Logger logger = LoggerFactory.getLogger(FootballScoreService.class);
    private final List<Match> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam) {
        validateTeams(homeTeam, awayTeam);

        if (matchExists(homeTeam, awayTeam)) {
            String errorMessage = String.format("Match already exists: %s vs %s", homeTeam, awayTeam);
            logger.error(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        try {
            Match match = new Match(homeTeam, awayTeam, 0, 0, Instant.now());
            matches.add(match);
            logger.info("Match started: {} vs {}", homeTeam, awayTeam);
        } catch (Exception e) {
            logger.error("Failed to start match: {} vs {} - {}", homeTeam, awayTeam, e.getMessage());
        }
    }

    public List<Match> getSummary() {
        return matches.stream()
                .sorted(Comparator.comparingInt((Match m) -> m.homeScore() + m.awayScore())
                        .reversed()
                        .thenComparing(Comparator.comparing(Match::startTime).reversed()))
                .collect(Collectors.toList());
    }

    private void validateTeams(String homeTeam, String awayTeam) {
        if (homeTeam == null || awayTeam == null || homeTeam.isEmpty() || awayTeam.isEmpty()) {
            logger.error("Home team and away team cannot be null or empty");
            throw new NullPointerException("Home team and away team cannot be null or empty");
        }
    }

    private boolean matchExists(String homeTeam, String awayTeam) {
        return matches.stream()
                .anyMatch(match -> match.homeTeam().equals(homeTeam) && match.awayTeam().equals(awayTeam));
    }
}
