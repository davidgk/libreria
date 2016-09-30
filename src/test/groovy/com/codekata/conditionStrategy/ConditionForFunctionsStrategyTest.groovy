package com.codekata.conditionStrategy

import com.codekata.conditionstrategy.ConditionForFunctionsStrategy
import com.codekata.conditionstrategy.OperacionAritmeticaStrategy
import org.junit.Before
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by davidgk on 26/07/16.
 */
class ConditionForFunctionsStrategyTest extends Specification {

    ConditionForFunctionsStrategy strategy
    @Before
    public void antes(){
        strategy = new OperacionAritmeticaStrategy();
        strategy.initialize();
    }

    @Unroll("test dado tres nros, #p1, #p2 y #p3  10,  si elijo la operacion #operation y subsiguientemente aplico #anotherOperation obtendre como resultado #resultexpected")
    void "test deseo Crear una estrategia comun basado en functions para operaciones entre dos nros"() {
        given:
            Double parametroA = p1;
            Double parametroB = p2;
            Double parametroC = p3;
        when:
            Double result = ((Double)strategy.runAction(operation).apply(parametroA,parametroB));
            if(anotherOperation != null){
                result =  (Double)strategy.runOverAction(anotherOperation, parametroC);
            }
        then:
            assert result == resultexpected;
        where:
            operation       | resultexpected | anotherOperation  | p1  | p2  | p3
            "SUMAR"         | 16D            | null              | 10  | 6   | 2
            "RESTAR"        | 4D             | null              | 10  | 6   | 2
            "MULTIPLICAR"   | 60D            | null              | 10  | 6   | 2
            "DIVIDIR"       | 2D             | null              | 10  | 5   | 2
            "SUMAR"         | 17D            | "SUMAR"           | 10  | 5   | 2
            "SUMAR"         | 13D            | "RESTAR"          | 10  | 5   | 2
            "SUMAR"         | 30D            | "MULTIPLICAR"     | 10  | 5   | 2
    }


}
