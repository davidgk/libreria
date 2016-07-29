package com.codekata.streamanalisis

import com.codekata.libreria.Book
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by davidgk on 28/07/16.
 */
class StreamAnalisisTest extends Specification {

    @Unroll("test cuando viene por lista un #booksToAdd deberia retornar como el nuevo array creado #output")
    void "test evitando nulos"() {
        given:
            StreamAnalisis analisis = new StreamAnalisis();
        when:
            def result = analisis.doStream(input, booksToAdd)
        then:
            assert result == output
        where:
        input                   | booksToAdd                   | output
        new ArrayList<Book>()   | null                         |  0
        new ArrayList<Book>()   | Arrays.asList(new Book())    |  1
        new ArrayList<Book>()   | Arrays.asList()              |  0


    }

}
