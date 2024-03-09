package com.ematiej.maven_course.review;

public interface BonusStrategy {
    double calculateBonusPoints(UserReviewed userReviewed, int userAge, double purchaseCostInPln) throws UserNotPremiumException;
}
