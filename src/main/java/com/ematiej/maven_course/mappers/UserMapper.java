package com.ematiej.maven_course.mappers;

import com.ematiej.maven_course.domain.User;
import com.ematiej.maven_course.model.UserCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserCommand userToUserCommand(User user);
    User userCommandToUser(UserCommand command);
}
