package com.ematiej.maven_course.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BonusReviewedServiceImpl implements IBonusService {

    private final MySqlRepository mySQLRepository;
    private final BonusStrategy bonusStrategy;

    @Autowired
    public BonusReviewedServiceImpl(MySqlRepository mySQLRepository, BonusStrategy bonusStrategy) {
        this.mySQLRepository = mySQLRepository;
        this.bonusStrategy = bonusStrategy;
    }


    @Override
    public Double grantPoints(String userId, int userAge, double purchaseCostInPln) {
        return mySQLRepository.findById(userId)
                .map(user -> {
                    try {
                        return bonusStrategy.calculateBonusPoints(user, userAge, purchaseCostInPln);
                    } catch (UserNotPremiumException e) {
                        System.out.println("Using log4J or something");
                        return 0.0;
//                        throw new RuntimeException(e);
                    }
                })
                .orElse(0.0);
    }
}
