package com.ematiej.maven_course.review;

import java.util.Optional;

public interface MySqlRepository {
    Optional<UserReviewed> findById(String userId);
    UserReviewed findByIdOld(String userId);

    void save(UserReviewed userReviewed);

}
