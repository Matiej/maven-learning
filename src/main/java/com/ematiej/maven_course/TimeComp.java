package com.ematiej.maven_course;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class TimeComp {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

    }
}
