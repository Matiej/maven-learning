package com.ematiej.maven_course.review;

public enum BonusParameters {
    // Enum instances
    BASE(0.8, 120, 1000, 2000, 18),
    PREMIUM(1.0, 150, 1500, 2500, 25), // Example of another set of parameters
    VIP(1.2, 200, 2000, 3000, 30); // Another example

    // Fields for each instance
    private final double multiplier;
    private final int basePoints;
    private final int minPointsForBonus;
    private final int maxPointsForBonus;
    private final int minAgeForBonus;

    // Enum constructor
    BonusParameters(double multiplier, int basePoints, int minPointsForBonus, int maxPointsForBonus, int minAgeForBonus) {
        this.multiplier = multiplier;
        this.basePoints = basePoints;
        this.minPointsForBonus = minPointsForBonus;
        this.maxPointsForBonus = maxPointsForBonus;
        this.minAgeForBonus = minAgeForBonus;
    }

    // Getters for the fields
    public double getMultiplier() {
        return multiplier;
    }

    public int getBasePoints() {
        return basePoints;
    }

    public int getMinPointsForBonus() {
        return minPointsForBonus;
    }

    public int getMaxPointsForBonus() {
        return maxPointsForBonus;
    }

    public int getMinAgeForBonus() {
        return minAgeForBonus;
    }
}
