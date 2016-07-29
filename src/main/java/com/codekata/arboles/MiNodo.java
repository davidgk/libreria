package com.codekata.arboles;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by davidgk on 28/07/16.
 */
public class MiNodo {
    private int amountLevels;
    private Integer myValue;
    private LinkedList<MiNodo> myNodesChildrens = new LinkedList<MiNodo>();


    private int position = 1;
    private int sizeList = 0;

    public MiNodo(Integer miValue) {
        this.myValue = miValue;
    }

    public MiNodo start(ArrayList<Integer> listaDeEnteros) {
        this.myValue = listaDeEnteros.get(0);
        sizeList = listaDeEnteros.size();
        this.amountLevels = 1;
        if(sizeList > 2){
            loadFirsLevelDouble(listaDeEnteros,sizeList -1);
        }

        if(sizeList == 2){
            this.amountLevels = 2;
            loadFirsLevel(listaDeEnteros,sizeList -1);
        }
        if(sizeList == 3){
            this.amountLevels = 2;
            this.myNodesChildrens.add(MiNodo.buildMeWithValue(listaDeEnteros.get(sizeList -1)));
        }
        if(sizeList == 4){
            this.amountLevels = 3;
            if((listaDeEnteros.get(sizeList-1)%2==0)){
                this.myNodesChildrens.get(0).myNodesChildrens.add(MiNodo.buildMeWithValue(listaDeEnteros.get(sizeList-1)));
            }
        }

        if(sizeList == 5){
            this.amountLevels = 3;
            for (int i = 3; i < 5 ; i++) {
                if((listaDeEnteros.get(i)%2==0)){
                    this.myNodesChildrens.get(0).myNodesChildrens.add(MiNodo.buildMeWithValue(listaDeEnteros.get(sizeList -2)));
                }else
                    this.myNodesChildrens.get(1).myNodesChildrens.add(MiNodo.buildMeWithValue(listaDeEnteros.get(sizeList -1)));
            }
        }
        if(sizeList == 6){
            this.amountLevels = 3;
            for (int i = 3; i < sizeList -1 ; i++) {
                if((listaDeEnteros.get(i)%2==0)){
                    this.myNodesChildrens.get(0).myNodesChildrens.add(MiNodo.buildMeWithValue(listaDeEnteros.get(sizeList-3)));
                }else
                    this.myNodesChildrens.get(1).myNodesChildrens.add(MiNodo.buildMeWithValue(listaDeEnteros.get(sizeList-2)));
            }
            if((listaDeEnteros.get(sizeList-1)%2==0)){
                this.myNodesChildrens.get(0).myNodesChildrens.add(MiNodo.buildMeWithValue(listaDeEnteros.get(sizeList-1),6));
            }else
                this.myNodesChildrens.get(1).myNodesChildrens.add(MiNodo.buildMeWithValue(listaDeEnteros.get(sizeList-2),6));

        }

        return this;
    }

    private void loadFirsLevelDouble(ArrayList<Integer> listaDeEnteros, int max) {
        for (int i = max; i > max-2 ; i--) {
            loadFirsLevel(listaDeEnteros, i);
        }
    }

    private void loadFirsLevel(List<Integer> listaDeEnteros, int index) {
        this.myNodesChildrens.add(MiNodo.buildMeWithValue(listaDeEnteros.get(sizeList -index)));
    }

    private static MiNodo buildMeWithValue(Integer miValue, int miposition) {
        MiNodo nodo = new MiNodo(miValue);
        nodo.setPosition(miposition);
        return  nodo;
    }

    private static MiNodo buildMeWithValue(Integer miValue) {
        MiNodo nodo = new MiNodo(miValue);
        return  nodo;
    }
    public int getLevels() {
        return amountLevels;
    }

    public int getTreeLevels() {
        return this.amountLevels;
    }


    public String getArrayBuildedPrinted() {
        StringBuilder result = new StringBuilder().append(myValue);
        if (myNodesChildrens != null) {
            if(sizeList ==2){
                result.append("[").append(myNodesChildrens.get(0).myValue);
            }
            if(sizeList ==3){
                result.append("[").append(myNodesChildrens.get(0).myValue);
                result.append(",").append(myNodesChildrens.get(1).myValue);
            }
            if(sizeList ==4){
                result.append("[").append(myNodesChildrens.get(0).myValue);
                result.append("[").append(myNodesChildrens.get(0).myNodesChildrens.get(0).myValue).append("]");
                result.append(",").append(myNodesChildrens.get(1).myValue);
            }
            if(sizeList ==5){
                result.append("[").append(myNodesChildrens.get(0).myValue);
                result.append("[").append(myNodesChildrens.get(0).myNodesChildrens.get(0).myValue).append("]");
                result.append(",").append(myNodesChildrens.get(1).myValue);
                result.append("[").append(myNodesChildrens.get(1).myNodesChildrens.get(0).myValue).append("]");
            }

            if(sizeList ==6){
                result.append("[").append(myNodesChildrens.get(0).myValue);
                result.append("[").append(myNodesChildrens.get(0).myNodesChildrens.get(0).myValue);
                result.append(",").append(myNodesChildrens.get(0).myNodesChildrens.get(1).myValue).append("]");
                result.append(",").append(myNodesChildrens.get(1).myValue);
                result.append("[").append(myNodesChildrens.get(1).myNodesChildrens.get(0).myValue).append("]");
            }

        }
        result.append((sizeList>1)?"]":"");
        return result.toString();
    }

    public void setPosition(int position) {
        this.position = position;
    }


}
