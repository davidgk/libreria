package com.codekata.doubledispatch;

/**
 * Created by davidgk on 26/07/16.
 */
public class ObjetoDelegadoA  extends AbstractObjetoHijo{
    @Override
    public String validate(ObjetoOwner objetoOwner) {
        return objetoOwner.hacerCosasSegun0();
    }
}
