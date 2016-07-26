package com.codekata.libreria;

import java.math.BigDecimal;

/**
 * Created by davidgk on 25/07/16.
 */
public class CreditCard  {

    public String creditCardNumber;
    public String creditCardExpiration;
    private IClient owner;
    private BigDecimal transactionAmount;

    public IClient getOwner() {
        return owner;
    }

    public void setOwner(IClient owner) {
        this.owner = owner;
    }


    public boolean isValidMedioPago() {

        try {

        }catch (Exception e){
            throw e;
        }
        return true;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCreditCardExpiration(String creditCardExpiration) {
        this.creditCardExpiration = creditCardExpiration;
    }
}
