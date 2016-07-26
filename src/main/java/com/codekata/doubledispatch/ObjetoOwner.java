package com.codekata.doubledispatch;

/**
 * Created by davidgk on 26/07/16.
 */
public class ObjetoOwner {
    public AbstractObjetoHijo hijo;
    public EnumFuncional miEnumValue;


    public String doTask() {
        return hijo.validate(this);
    }

    public String doTaskWithEnum() {
        return miEnumValue.validate(this);
    }

    public String hacerCosasSegun0(){
        return "A";
    }

    public String hacerCosasSegun1(){
        return "B";
    }
}
