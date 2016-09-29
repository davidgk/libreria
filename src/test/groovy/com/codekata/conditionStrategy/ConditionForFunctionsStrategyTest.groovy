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

    @Unroll("test dado dos nros, 5 y 10,  si elijo la operacion #operation obtendre como resultado #resultexpected")
    void "test deseo Crear una estrategia comun basado en functions para operaciones entre dos nros"() {
        given:
            Double parametroA = 10;
            Double parametroB = 5;
            Double parametroC = 2;
        when:
            Double result = ((Double)strategy.runAction(operation).apply(parametroA,parametroB));
            if(anotherOperation != null){
                result =  (Double)strategy.runOverAction(anotherOperation, parametroC);
            }
        then:
            assert result == resultexpected;
        where:
            operation       | resultexpected | anotherOperation
            "SUMAR"         | 15D            | null
            "RESTAR"        | 5D             | null
            "MULTIPLICAR"   | 50D            | null
            "DIVIDIR"       | 2D             | null
            "SUMAR"         | 17D            | "SUMAR"
            "SUMAR"         | 13D            | "RESTAR"
    }


}
