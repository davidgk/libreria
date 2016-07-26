package com.codekata.others;

/**
 * Created by davidgk on 26/07/16.
 */
public class FibonacciPreJava8Resolver {

    public String fibonacci(int value){
        int initial =1;
        StringBuffer buffer=  getInitialBuffer(initial);
        if(value <=1  ){
            return (value==0)? "1":buffer.append("1").toString();
        }else{
            buffer.append(getInitialBuffer(initial));
            for (int i = 0; i < (value -2); i++) {
                Integer[] lastTwoValues = getLastTwoValues(buffer);
                buffer.append(getInitialBuffer(lastTwoValues[1]+lastTwoValues[0]));
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
        int lastValue = new Integer(listValues[listValues.length -1]);
        int penultimo = new Integer(listValues[listValues.length -2]);
        return new Integer[]{penultimo,lastValue};
    }

    public StringBuffer getInitialBuffer(int lastValue){
        return  new StringBuffer(String.valueOf(lastValue)).append(",");
    }


}
