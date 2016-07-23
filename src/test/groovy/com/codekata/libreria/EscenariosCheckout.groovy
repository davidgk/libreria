package com.codekata.libreria

import spock.lang.Specification

/**
 * Created by davidgk on 22/07/16.
 */
class EscenariosCheckout extends Specification{


    void "test Cuando se decide a liquidar el Carrito deberíamos saber el precio total a abonar"(){
        given:
            Carrito carrito = Utils.createEnvironment(3, 2)
            carrito.addBook(Utils.getBook("1"))
            carrito.addBook(Utils.getBook("1"))
            carrito.addBook(Utils.getBook("2"))
            carrito.addBook(Utils.getBook("2"))
            carrito.addBook(Utils.getBook("3"))
            carrito.addBook(Utils.getBook("3"))
        when:
            BigDecimal totalAmount = carrito.checkout()
        then:
            assert new BigDecimal(60).equals(totalAmount)
    }



}
