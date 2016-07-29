package com.codekata.arboles

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by davidgk on 28/07/16.
 */
class ArbolesTest extends Specification {

    @Unroll("test mi tests")
    void "test 01"() {
        given:
            MiNodo nodo = new MiNodo(null);
        when:
            MiNodo armado = nodo.start(listaNumeros)
        then:
            assert armado.getLevels() == levelsExpected
            assert armado.getArrayBuildedPrinted().equals(arrayBuildedPrinted)
        where:
            listaNumeros | levelsExpected   | arrayBuildedPrinted
            [1,2,3,4,5,6]| 3                | "1[2[4,6],3[5]]"
            [1,2,3,4,5]  | 3                | "1[2[4],3[5]]"
            [1,2,3,4]    | 3                | "1[2[4],3]"
            [1,2,3]      | 2                | "1[2,3]"
            [1,2]        | 2                | "1[2]"
            [1]          | 1                | "1"


    }
}
