package com.ematiej.maven_course.review;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MySqlRepository {
    Optional<User> findById(String userId);
    User findByIdOld(String userId);

    void save(User user);

}
