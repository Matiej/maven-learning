package com.ematiej.maven_course.review;

public interface BonusStrategy {
    double calculateBonusPoints(User user, int userAge, double purchaseCostInPln) throws UserNotPremiumException;
}
