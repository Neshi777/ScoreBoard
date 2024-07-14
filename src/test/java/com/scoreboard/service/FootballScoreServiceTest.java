package com.scoreboard.service;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FootballScoreServiceTest {


    @ParameterizedTest(name = "Starting match between {0} and {1}")
    @CsvSource({
            "Team A, Team B",
            "Team C, Team D",
            "Team E, Team F"
    })
    public void testStartMatch(String homeTeam, String awayTeam) {

    }

    @ParameterizedTest(name = "Updating score for match between {0} and {1}")
    @CsvSource({
            "Team A, Team B, 1, 2",
            "Team C, Team D, 3, 4",
            "Team E, Team F, 5, 6"
    })
    public void testUpdateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {

    }

    @ParameterizedTest(name = "Finishing match between {0} and {1}")
    @MethodSource("provideFinishMatchParameters")
    public void testFinishMatch(String homeTeam, String awayTeam) {

    }

    private static Stream<Arguments> provideFinishMatchParameters() {
        return Stream.of(
                Arguments.of("Team A", "Team B"),
                Arguments.of("Team C", "Team D"),
                Arguments.of("Team E", "Team F")
        );
    }

    @ParameterizedTest(name = "Getting summary for matches")
    @MethodSource("provideSummaryParameters")
    public void testGetSummary(String homeTeam1, String awayTeam1, int homeScore1, int awayScore1,
                               String homeTeam2, String awayTeam2, int homeScore2, int awayScore2) {
        // Start match 1

        // Start match 2

        // Update score for match 1

        // Update score for match 2

        // Get summary

        // Validate summary

        // Check ordering by total score descending, then by start time descending
    }

    private static Stream<Arguments> provideSummaryParameters() {
        return Stream.of(
                Arguments.of("Team A", "Team B", 1, 2, "Team C", "Team D", 3, 4),
                Arguments.of("Team E", "Team F", 2, 3, "Team G", "Team H", 4, 5)
        );
    }



    // Exceptions tests

    @Nested
    class UpdateScoreTests {

        @ParameterizedTest(name = "Update score with negative values: {0} vs {1}, homeScore={2}, awayScore={3}")
        @CsvSource({
                "Home Team, Away Team, -1, 0",
                "Team A, Team B, 1, -1",
                "Team C, Team D, -2, -3"
        })
        void updateScore_negativeScores_throwsIllegalArgumentException(String homeTeam, String awayTeam, int homeScore, int awayScore) {

        }

        @ParameterizedTest(name = "Updating score for nonexistent match: home={0}, away={1}")
        @CsvSource({
                "Nonexistent Team, Away Team",
                "Team A, Team X",
                "Team B, Team Y"
        })
        void updateScore_matchNotFound_throwsIllegalArgumentException(String homeTeam, String awayTeam) {

        }
    }

    @Nested
    class StartMatchTests {

        @ParameterizedTest(name = "Start match with null or empty teams: home={0}, away={1}")
        @CsvSource({
                "Home Team, ",
                ", Away Team",
                ", "
        })
        void startMatch_nullOrEmptyTeams_throwsNullPointerException(String homeTeam, String awayTeam) {
        }


        @ParameterizedTest(name = "Start match with teams: home={0}, away={1}")
        @CsvSource({
                "Team A, Team B",
                "Team X, Team Y",
                "Team C, Team D"
        })
        void startMatch_duplicateMatch_throwsIllegalArgumentException(String homeTeam, String awayTeam) {
            // Start the match once

            // Attempt to start the match again with the same teams

            // Assert the exception message
        }
    }

    @Nested
    class FinishMatchTests {

        @ParameterizedTest(name = "Finish match with nonexistent teams: home={0}, away={1}")
        @CsvSource({
                "Nonexistent Team, Away Team",
                "Team A, Nonexistent Team",
                ", Away Team",
                "Home Team, ",
                ", "
        })
        void finishMatch_matchNotFound_throwsIllegalArgumentException(String homeTeam, String awayTeam) {

        }
    }
}