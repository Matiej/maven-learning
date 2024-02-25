package com.ematiej.maven_course.review;

public class UserBonusException extends Throwable {
    private final String id;

    public UserBonusException(String id, String message) {
        super(message);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
