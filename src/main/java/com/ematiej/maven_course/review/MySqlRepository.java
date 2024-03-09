package com.ematiej.maven_course.review;

import java.util.Optional;

public interface MySqlRepository {
    Optional<User> findById(String userId);
    User findByIdOld(String userId);

    void save(User user);

}
