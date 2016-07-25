package com.codekata.libreria

import spock.lang.Specification

/**
 * Created by davidgk on 22/07/16.
 */
class EscenariosCheckout extends Specification{



    void "test Cuando se decide a liquidar el Carrito el cajero contabiliza el monto de los libros y nos dice el precio total a abonar"(){
        given:
            Carrito carrito = Utils.createEnvironment(3, 2)
            carrito.addBook(Utils.getBook("1"))
            carrito.addBook(Utils.getBook("1"))
            carrito.addBook(Utils.getBook("2"))
            carrito.addBook(Utils.getBook("2"))
            carrito.addBook(Utils.getBook("3"))
            carrito.addBook(Utils.getBook("3"))
            Cajero cajero = new Cajero(currentSell:  new Sell());
            cajero.currentSell.receiveCarritoToCharge(carrito);
        when:
            BigDecimal totalAmount = cajero.doCheckout();
        then:
            assert new BigDecimal(60).equals(totalAmount)
    }

    void "test cuando el cajero recibe el ok de la compra valida el medio de cobro y lo envia al merchantOrder"(){
        given:
            Carrito carrito = Utils.createEnvironment(1, 1)
            carrito.addBook(Utils.getBook("1"))
            Cajero cajero = new Cajero(currentSell:  new Sell(), merchantOrderProcessor: new StubMerchantOrderProcessor());
            cajero.currentSell.receiveCarritoToCharge(carrito);
            cajero.currentSell.receiveCarritoToCharge(carrito);
            cajero.currentSell.setMedioDePago(new CreditCard(creditCardNumber: "aNumber"
                    ,creditCardExpiration: "072016", owner: new StandardCustomer(name:"carlos"),
            transactionAmount:10.00))
            BigDecimal amount = cajero.doCheckout()
        when:
        ProcessStatus processStatus =cajero.realizarCobroVentaActual(amount);
        then:
        assert processStatus.status.equals(0)
        assert processStatus.message.equals("OK")
    }

    void "test cuando el cajero efectua el proceso de venta y el merchantOrder falla por alguna causa debe recibir la exception"(){
        given:
        Carrito carrito = Utils.createEnvironment(1, 1)
        carrito.addBook(Utils.getBook("1"))
        StubMerchantOrderProcessor stubMerchantOrderProcessor =[doCobro:{throw new Exception("Something Fail!")}] as StubMerchantOrderProcessor;
        Cajero cajero = new Cajero(currentSell:  new Sell(), merchantOrderProcessor: stubMerchantOrderProcessor);
        cajero.currentSell.receiveCarritoToCharge(carrito);
        cajero.currentSell.receiveCarritoToCharge(carrito);
        cajero.currentSell.setMedioDePago(new CreditCard(creditCardNumber: "aNumber"
                ,creditCardExpiration: "072016", owner: new StandardCustomer(name:"carlos"),
                transactionAmount:10.00))
        BigDecimal amount = cajero.doCheckout()
        when:
            ProcessStatus processStatus =cajero.realizarCobroVentaActual(amount);
        then:
            assert processStatus.status.equals(1)
            assert processStatus.message.equals("Something Fail!")
    }

    /***
    * TODO : Hacer las validaciones de la tarjeta
     * hacer los servicios rest reales
     * hacer el modelado de la parte del archivo.
     *
     *
     */

}
