package com.codekata.others;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by davidgk on 26/07/16.
 */
public class FibonacciJava8Resolver {

    BiFunction<String[],Integer,Integer> getDataFromArray = (someArray,parm)->new Integer(someArray[someArray.length -parm]);

    public String fibonacci(int value){
        int initial =1;
        Function<Integer,StringBuffer> getInitial = (someValue)->new StringBuffer(String.valueOf(someValue)).append(",");
        StringBuffer buffer= getInitial.apply(initial);
        if(value <=1  ){
            return (value==0)? "1":buffer.append("1").toString();
        }else{
            buffer.append(getInitial.apply(initial));
            for (int i = 0; i < (value -2); i++) {
                Integer[] lastTwoValues = getLastTwoValues(buffer);
                buffer.append(getInitial.apply(lastTwoValues[1] + lastTwoValues[0]));
            }
            return finalizeIt(buffer);
        }
    }

    private String finalizeIt(StringBuffer buffer){
        Integer[] lastTwoValues = getLastTwoValues(buffer);
        return buffer.append(lastTwoValues[1]+lastTwoValues[0]).toString();
    }

    public Integer[] getLastTwoValues(StringBuffer buffer){
        String[] listValues = buffer.toString().split(",");
        return new Integer[]{ getDataFromArray.apply(listValues,1), getDataFromArray.apply(listValues,2)};
    }




}
