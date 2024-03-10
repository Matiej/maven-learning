package com.ematiej.maven_course.mavenfortesting;


public class JavaHelloTestWorldTest {

    //for pojo test convension is that at the begining should be "test" world then maven pick it up and run without any annotations
    public void testGetHello() {
        //given
        String expectedValue = "Java Testing Hello for pojo22222";
        JavaHelloTestWorld javaHelloTestWorld = new JavaHelloTestWorld();

        //when
        String testHello = javaHelloTestWorld.getHello();

        //then
        assert(expectedValue.equals(testHello));

    }
}