package com.scoreboard.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FootballScoreIntegrationTest {


    @ParameterizedTest(name = "Starting match between {0} and {1}")
    @CsvSource({
            "Mexico, Canada, 0, 5",
            "Spain, Brazil, 10, 2",
            "Germany, France, 2, 2"
    })
    void testFootballScoreServiceIntegration(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        // Start match

        // Update score

        // Get summary

        // Validate summary

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

        // Update score

        // Get and verify summary

        // Finish match

        // Ensure match is removed
    }

}