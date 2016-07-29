package com.codekata.doubledispatch

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by davidgk on 26/07/16.
 */
class DoubleDispatchTest  extends Specification {

    @Unroll("test cuando el atributoFlag es #atributoFlag implica el uso del objeto inyectado  ObjetoDelegado#output entonces hace que el padre devuelva #output")
    void "test Double Dispatch entre clases"() {
        given:
            AbstractObjetoHijo hijo = cualcrear
            ObjetoOwner owner = new ObjetoOwner(hijo:hijo)
        when:
            String result = owner.doTask();
        then:
            assert result.equals(output)
        where:
        atributoFlag | output | cualcrear
        0            | "A"    | new ObjetoDelegadoA()
        1            | "B"    | new ObjetoDelegadoB()

    }

    @Unroll("test cuando el atributoFlag es #atributoFlag implica el uso del objeto inyectado  ObjetoDelegado#output entonces hace que el padre devuelva #output")
    void "test Double Dispatch usando Enums"() {
        given:
            EnumFuncional atributoEnum = enumValue
            ObjetoOwner owner = new ObjetoOwner(miEnumValue: atributoEnum)
        when:
            String result = owner.doTaskWithEnum();
        then:
            assert result.equals(output)
        where:
             output | enumValue
             "A"    | EnumFuncional.HACIENDO_0
             "B"    | EnumFuncional.HACIENDO_1

    }


}
