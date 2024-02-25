package com.ematiej.maven_course.review;

public class UserNotPremiumException extends UserBonusException {
    public UserNotPremiumException(String id) {
        super(id, "Some message");
    }
}
