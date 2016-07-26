package com.codekata.others

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by davidgk on 26/07/16.
 */
class FibonacciTest extends Specification {

    @Unroll("test para el valor #steps tendremos #output pre Java 8")
    void "test para el valor input tendremos output preJava 8"() {
        given:
        FibonacciPreJava8Resolver sut = new FibonacciPreJava8Resolver();
        when:
        String value = sut.fibonacci(steps)
        then:
        assert value.equals(output)
        where:
        steps       | output
        0           | "1"
        1           | "1,1"
        2           | "1,1,2"
        3           | "1,1,2,3"
        4           | "1,1,2,3,5"
        5           | "1,1,2,3,5,8"
        6           | "1,1,2,3,5,8,13"
        15          | "1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987"
    }


    @Unroll("test para el valor #steps tendremos #output Java 8 ways")
    void "test para el valor input tendremos output - Java 8 ways"() {
        given:
        FibonacciJava8Resolver sut = new FibonacciJava8Resolver();
        when:
        String value = sut.fibonacci(steps)
        then:
        assert value.equals(output)
        where:
        steps       | output
        0           | "1"
        1           | "1,1"
        2           | "1,1,2"
        3           | "1,1,2,3"
        4           | "1,1,2,3,5"
        5           | "1,1,2,3,5,8"
        6           | "1,1,2,3,5,8,13"
        15          | "1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987"
    }
}
