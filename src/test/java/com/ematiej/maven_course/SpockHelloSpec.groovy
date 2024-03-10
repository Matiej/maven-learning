package com.ematiej.maven_course

import spock.lang.Specification

class SpockHelloSpec extends Specification {
    def "GetSpockHello"() {
        when:
        def foo = "123"

        then:
        println("######################## Finished Test #########################")
        true
    }
}
