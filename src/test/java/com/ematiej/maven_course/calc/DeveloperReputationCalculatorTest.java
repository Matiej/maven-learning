package com.ematiej.maven_course.calc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeveloperReputationCalculatorTest {

    private DeveloperReputationCalculator calculator;
    private Developer developerMock;


    @BeforeEach
    void setUp() {
        calculator = new DeveloperReputationCalculator();
        developerMock = mock(Developer.class);
    }

    @Test
    @DisplayName("Calculate reputation score as 0 when developer has no followers")
    void calculateReputationScore_NoFollowers_ShouldReturnZero() {
        when(developerMock.getFollowers()).thenReturn(Collections.emptyList());

        int score = calculator.calculate(developerMock);

        assertEquals(0, score, "Reputation score should be 0 when there are no followers");
    }

    @Test
    @DisplayName("Calculate reputation score as double the number of followers")
    void calculateReputationScore_WithFollowers_ShouldReturnDoubleFollowersCount() {
        List<Developer> followers = List.of(new Developer("follower1", null), new Developer("follower2", null));
        when(developerMock.getFollowers()).thenReturn(followers);

        int score = calculator.calculate(developerMock);

        assertEquals(followers.size() * DeveloperReputationCalculator.getFollowersMultiplier(), score,
                "Reputation score should be double the number of followers");
    }

    @Test
    @DisplayName("Calculate reputation score with Hacktober bonus during October")
    void calculateReputationScore_DuringHacktober_ShouldIncludeBonus() {
        List<Developer> followers = List.of(new Developer("follower1", null));
        when(developerMock.getFollowers()).thenReturn(followers);

        calculator.setClock(Clock.fixed(Instant.parse("2024-10-15T00:00:00Z"), ZoneOffset.UTC));

        int score = calculator.calculate(developerMock);

        assertEquals((followers.size() * DeveloperReputationCalculator.getFollowersMultiplier()) + DeveloperReputationCalculator.getHacktoberBonus(),
                score, "Reputation score should include Hacktober bonus during October");
    }

    @Test
    @DisplayName("Calculate reputation score handles null followers list without exception")
    void calculateReputationScore_NullFollowersList_ShouldReturnZero() {
        when(developerMock.getFollowers()).thenReturn(null);

        int score = calculator.calculate(developerMock);

        assertEquals(0, score, "Reputation score should be 0 when followers list is null");
    }
}