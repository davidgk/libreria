package com.codekata.conditionstrategy;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Created by davidgk on 29/09/16.
 */
public abstract class ConditionForFunctionsStrategy {

    private Map<Object, Object> mapStrategiesForFunction = new HashMap<>();
    public Object result;

    protected void initializeInternal(List argsKeys, List argsFunctions) {
        if (argsKeys.size() != argsFunctions.size()) throw  new RuntimeException("Cantidad de Condiciones deben ser igual a las Acciones");
        for (int i = 0; i < argsKeys.size(); i++) {
            this.mapStrategiesForFunction.put(argsKeys.get(i), argsFunctions.get(i));
        }

    }

    @PostConstruct
    public  void initialize(){
        throw new RuntimeException("Tenes que implementar las funciones, las cosas no corren solas!");
    }


    public Object runAction(Object action){
        return this.mapStrategiesForFunction.get(action);

    }

    public Object runOverAction(String operation,Object parametroC){
        return ((BiFunction) mapStrategiesForFunction.get(operation)).apply(this.result, parametroC);

    }


}
