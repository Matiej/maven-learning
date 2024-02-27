package com.ematiej.maven_course.review;

public class MembershipService {

    private MembershipService() {
    }

    public static MembershipService getInstance() {
        return new MembershipService();
    }

    public int getStatus(String userId) {
        return 1;
    }
}
