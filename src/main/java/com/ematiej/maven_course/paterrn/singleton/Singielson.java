package com.ematiej.maven_course.paterrn.singleton;

public class Singielson {
    private static Singielson instance;
    private Singielson() {};

    public static synchronized Singielson getInstance() {
        if(instance == null) {
            return new Singielson();
        }
        return instance;
    }
}
