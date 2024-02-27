package com.ematiej.maven_course.calc;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public class DeveloperReputationCalculator {
    private static final int FOLLOWERS_MULTIPLIER = 2;
    private static final int HACKTOBER_BONUS = 10;
    private Clock clock = Clock.systemDefaultZone();

    //method added to use it for tests.
    public static int getFollowersMultiplier() {
        return FOLLOWERS_MULTIPLIER;
    }

    // methodd added to use it for unit test, could be good to setUp hardcoded variables in some dictionary or enum maybe.
    public static int getHacktoberBonus() {
        return HACKTOBER_BONUS;
    }

    //method added in order to write tests
    public void setClock(Clock clock) {
        this.clock = clock;
    }

    //method added in order to write tests
    private ZonedDateTime now() {
        return ZonedDateTime.now(clock);
    }

    public int calculate(Developer developer) {
        final int followersScore = Optional.ofNullable(developer.getFollowers())
                .map(List::size)
                .map(cnt -> cnt * FOLLOWERS_MULTIPLIER)
                .orElse(0);
        //final ZonedDateTime now = ZonedDateTime.now(); original version
        final ZonedDateTime now = now();

        final boolean duringHactober = now.getMonth() == Month.OCTOBER;

        if (duringHactober) {
            return followersScore + HACKTOBER_BONUS;
        } else {
            return followersScore;
        }

    }
}
