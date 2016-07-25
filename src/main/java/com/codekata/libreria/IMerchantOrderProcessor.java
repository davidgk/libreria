package com.codekata.libreria;

/**
 * Created by davidgk on 25/07/16.
 */
public interface IMerchantOrderProcessor {

    Integer doCobro(CreditCard medioDePago) throws Exception;


}
