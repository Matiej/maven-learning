package com.ematiej.maven_course.mavenfortesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Junit5JavaHelloWorldTest {

    @Test
    void getJunit5Hello() {
        //given
        String expectedValue = "Junit5 Hello";
        Junit5JavaHelloWorld junit5JavaHelloWorld = new Junit5JavaHelloWorld();

        //when
        String junit5Hello = junit5JavaHelloWorld.getJunit5Hello();

        //then
        assertEquals(expectedValue, junit5Hello);

    }
}