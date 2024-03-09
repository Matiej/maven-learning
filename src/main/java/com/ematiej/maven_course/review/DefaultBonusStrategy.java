package com.ematiej.maven_course.review;

import org.springframework.stereotype.Component;

@Component
public class DefaultBonusStrategy implements BonusStrategy {
    //consider if this data should be in some dictionary in database
    private static final double BASE_BONUS_MULTIPLIER = BonusParameters.BASE.getMultiplier();
    private static final int BASE_BONUS_POINTS = BonusParameters.BASE.getBasePoints();
    private static final int MIN_POINTS_FOR_BONUS = BonusParameters.BASE.getMinPointsForBonus();
    private static final int MAX_POINTS_FOR_BONUS = BonusParameters.BASE.getMaxPointsForBonus();
    private static final int MIN_AGE_FOR_BONUS = BonusParameters.BASE.getMinAgeForBonus();

    @Override
    public double calculateBonusPoints(UserReviewed userReviewed, int userAge, double purchaseCostInPln) throws UserNotPremiumException {
        int membershipStatus = MembershipService.getInstance().getStatus(userReviewed.getId());
        if (membershipStatus != 1) {
            throw new UserNotPremiumException(userReviewed.getId());
        }

        double points = purchaseCostInPln * BASE_BONUS_MULTIPLIER + BASE_BONUS_POINTS;
        if (isEligibleForBonus(points, userAge)) {
            userReviewed.setPoints(userReviewed.getPoints() + points);
            return points;
        }

        return 0.0;
    }

    private boolean isEligibleForBonus(double points, int userAge) {
        return points > MIN_POINTS_FOR_BONUS && points <= MAX_POINTS_FOR_BONUS && userAge > MIN_AGE_FOR_BONUS;
    }
}
