package com.ematiej.maven_course.review;

public class BonusServiceImpl implements IBonusService {
    public MySqlRepository mySqlRepository;

    @Override
    public Double grantPoints(String userId, int userAge, double purchaseCostPln) {
        User user;
        try {
            user = mySqlRepository.findByIdOld(userId);
        } catch (Throwable t) {
            System.err.println(t);
            return null;
        }

        if (user == null) {
            return 0.0;
        }

        int m = MembershipService.getInstance().getStatus(userId);

        if (m == 1) {
            double p = purchaseCostPln * 0.8 + 120;
            if (p > 1000 && p <= 2000 && userAge > 18) {
                user.setPoints(user.getPoints() + p);
                mySqlRepository.save(user);

                return p;
            } else {
                throw new RuntimeException("User not a premium meber");
            }
        }

        return 0.0;

    }
}
