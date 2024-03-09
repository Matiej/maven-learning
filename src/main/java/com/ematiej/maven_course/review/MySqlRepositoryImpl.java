package com.ematiej.maven_course.review;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MySqlRepositoryImpl implements MySqlRepository {
    @Override
    public Optional<User> findById(String userId) {
        return Optional.empty();
    }

    @Override
    public User findByIdOld(String userId) {
        return null;
    }

    @Override
    public void save(User user) {

    }
}
