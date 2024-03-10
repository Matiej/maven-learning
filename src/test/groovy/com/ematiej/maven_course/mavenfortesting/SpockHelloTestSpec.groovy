package com.ematiej.maven_course.mavenfortesting

import spock.lang.Specification

class SpockHelloTestSpec extends Specification {
    def "GetSpockHello"() {
        when:
        def foo = "123"

        then:
        println("######################## Finished Test #########################")
        true
    }
}
