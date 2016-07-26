package com.codekata.doubledispatch;

/**
 * Created by davidgk on 26/07/16.
 */
public enum EnumFuncional {

    HACIENDO_0 {
        @Override
        public String validate(ObjetoOwner objetoOwner) {
            return objetoOwner.hacerCosasSegun0();
        }
    },HACIENDO_1 {
        @Override
        public String validate(ObjetoOwner objetoOwner) {
            return objetoOwner.hacerCosasSegun1();

        }
    };

    public abstract String validate(ObjetoOwner objetoOwner);
}
