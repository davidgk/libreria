package com.codekata.libreria;

/**
 * Created by davidgk on 25/07/16.
 */
public class Sell {
    public Carrito carritoACobrar;
    public CreditCard medioDePago;

    public CreditCard getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(CreditCard medioDePago) {
        this.medioDePago = medioDePago;
    }


    public void receiveCarritoToCharge(Carrito carrito) {
        this.carritoACobrar = carrito;
    }


    public void makeValidations() {
        this.getMedioDePago().isValidMedioPago();
    }
}
