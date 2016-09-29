package com.codekata.conditionstrategy;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Created by davidgk on 29/09/16.
 */
public class OperacionAritmeticaStrategy extends ConditionForFunctionsStrategy {


    public BiFunction<Double, Double, Double> sumarFunction = (a, b)->{
        this.result =  a+b;
        return (Double)result;
    };

    public BiFunction<Double, Double, Double> restarFunction = (a, b)->{
        this.result =  a-b;
        return (Double)result;
    };

    public BiFunction<Double, Double, Double> multiplicarFunction = (a, b)->{
        this.result =  a*b;
        return (Double)result;
    };

    public BiFunction<Double, Double, Double> dividirFunction = (a, b)->{
        if (b!= 0){
            this.result =  a/b;
            return (Double)result;
        }
        throw new RuntimeException("No podes dividir por 0");
    };


    @Override
    @PostConstruct
    public void initialize() {
        this.initializeInternal(Arrays.asList("SUMAR","RESTAR","MULTIPLICAR", "DIVIDIR"), Arrays.asList(this.sumarFunction,this.restarFunction, this.multiplicarFunction,this.dividirFunction));
    }
}
