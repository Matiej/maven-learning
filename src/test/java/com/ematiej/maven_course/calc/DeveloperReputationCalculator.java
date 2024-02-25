package com.ematiej.maven_course.calc;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public class DeveloperReputationCalculator {
    private static final int FOLLOWERS_MULTIPLIER = 2;
    private static final int HACKTOBER_BONUS = 10;

    public int calculate(Developer developer) {
        final int followersScore = Optional.ofNullable(developer.getFollowers())
                .map(List::size)
                .map(cnt -> cnt * FOLLOWERS_MULTIPLIER)
                .orElse(0);
        final ZonedDateTime now = ZonedDateTime.now();

        final boolean duringHactober = now.getMonth() == Month.OCTOBER;

        if (duringHactober) {
            return followersScore + HACKTOBER_BONUS;
        } else {
            return followersScore;
        }

    }
}
