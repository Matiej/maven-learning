package com.ematiej.maven_course.model;


import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class UserCommand {
    private String name;
    private String lastname;
    private String email;
}
