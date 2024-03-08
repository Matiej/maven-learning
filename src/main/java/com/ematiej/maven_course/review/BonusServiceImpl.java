package com.ematiej.maven_course.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BonusServiceImpl implements IBonusService {
    //Dependency Injection: Constructor injection is used instead of field injection.
    public MySqlRepository mySqlRepository;
//The MySQLRepository and MembershipService are final, ensuring that they are not changed after construction.

    @Override
    public Double grantPoints(String userId, int userAge, double purchaseCostPln) {
        User user;
        try {
            user = mySqlRepository.findByIdOld(userId);
            //Exception Handling: Specific exceptions are caught, and a custom exception (UserNotFoundException) is thrown if the user is not found.
        } catch (Throwable t) {
            //rror Logging: SLF4J logging framework is used instead of System.err.println()
            System.err.println(t);

            //Return Type: Methods now return Optional<Double> to handle the absence of a value properly.
            return null;
        }

        if (user == null) {
            return 0.0;
        }

        int m = MembershipService.getInstance().getStatus(userId);

        if (m == 1) {
            //Constants: Magic numbers have been extracted as constants with descriptive names.
            double p = purchaseCostPln * 0.8 + 120;
            //The business rule for calculating bonus points has been extracted into a separate method to make it clearer and easier to change.
            if (p > 1000 && p <= 2000 && userAge > 18) {
                user.setPoints(user.getPoints() + p);
                mySqlRepository.save(user);

                return p;
            } else {
                //An exception is thrown instead of returning a default value when the user is not a premium member, indicating that the operation should not continue.
                throw new RuntimeException("User not a premium meber");
            }
        }

        return 0.0;

    }

    @Autowired
    public void setMySqlRepository(MySqlRepository repository) {
        // is a Spring Data repository and that it handles resource management automatically.
        this.mySqlRepository = repository;
    }
}
