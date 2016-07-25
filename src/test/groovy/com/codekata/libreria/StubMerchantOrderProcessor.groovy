package com.codekata.libreria

/**
 * Created by davidgk on 25/07/16.
 */
class StubMerchantOrderProcessor implements IMerchantOrderProcessor{

    @Override
    Integer doCobro(CreditCard medioDePago) throws Exception {
        return 0;

    }
}
