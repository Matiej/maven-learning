package com.ematiej.maven_course.review;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MySqlRepositoryImpl implements MySqlRepository {
    @Override
    public Optional<UserReviewed> findById(String userId) {
        return Optional.empty();
    }

    @Override
    public UserReviewed findByIdOld(String userId) {
        return null;
    }

    @Override
    public void save(UserReviewed userReviewed) {

    }
}
