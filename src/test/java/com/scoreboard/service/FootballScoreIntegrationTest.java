package com.scoreboard.service;

import com.scoreboard.model.Match;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballScoreIntegrationTest {
    private FootballScoreService service;

    @BeforeEach
    public void setup() {
        service = new FootballScoreService();
    }

    @AfterEach
    public void cleanup() {
        service.clearScoreboard();
    }

    @ParameterizedTest(name = "Starting match between {0} and {1}")
    @CsvSource({
            "Mexico, Canada, 0, 5",
            "Spain, Brazil, 10, 2",
            "Germany, France, 2, 2"
    })
    void testFootballScoreServiceIntegration(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        // Start match
        service.startMatch(homeTeam, awayTeam);

        // Update score
        service.updateScore(homeTeam, awayTeam, homeScore, awayScore);

        // Get summary
        List<Match> matches = service.getSummary();

        // Validate summary
        assertMatchOrder(matches);
        assertEquals(homeTeam, matches.get(0).homeTeam());
        assertEquals(awayTeam, matches.get(0).awayTeam());
        assertEquals(homeScore, matches.get(0).homeScore());
        assertEquals(awayScore, matches.get(0).awayScore());
    }

    @ParameterizedTest(name = "Add, update, and remove match between {0} and {1}")
    @CsvSource({
            "Mexico, Canada, 0, 5",
            "Spain, Brazil, 10, 2",
            "Germany, France, 2, 2",
            "Uruguay, Italy, 6, 6",
            "Argentina, Australia, 3, 1"
    })
    void testAddUpdateAndRemoveMatch(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        // Add a match
        service.startMatch(homeTeam, awayTeam);

        // Update score
        service.updateScore(homeTeam, awayTeam, homeScore, awayScore);

        // Get and verify summary
        List<Match> matches = service.getSummary();
        assertMatchOrder(matches);
        assertEquals(1, matches.size());
        assertEquals(homeTeam, matches.get(0).homeTeam());
        assertEquals(awayTeam, matches.get(0).awayTeam());
        assertEquals(homeScore, matches.get(0).homeScore());
        assertEquals(awayScore, matches.get(0).awayScore());

        // Finish match
        service.finishMatch(homeTeam, awayTeam);

        // Ensure match is removed
        matches = service.getSummary();
        assertEquals(0, matches.size());
    }

    private void assertMatchOrder(List<Match> matches) {
        for (int i = 1; i < matches.size(); i++) {
            Match currentMatch = matches.get(i);
            Match previousMatch = matches.get(i - 1);

            int currentScoreSum = currentMatch.homeScore() + currentMatch.awayScore();
            int previousScoreSum = previousMatch.homeScore() + previousMatch.awayScore();

            // Compare by score sum descending
            if (currentScoreSum > previousScoreSum) {
                continue;
            } else if (currentScoreSum < previousScoreSum) {
                throw new AssertionError(String.format("Matches not ordered correctly by score at index %d and %d", i - 1, i));
            }

            // If scores are equal, compare by start time descending
            if (currentMatch.startTime().compareTo(previousMatch.startTime()) < 0) {
                throw new AssertionError(String.format("Matches not ordered correctly by start time at index %d and %d", i - 1, i));
            }
        }
    }
}