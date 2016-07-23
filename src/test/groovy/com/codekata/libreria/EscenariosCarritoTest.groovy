package com.codekata.libreria

import spock.lang.Specification

/**
 * Created by davidgk on 22/07/16.
 */
class EscenariosCarritoTest extends Specification{



    void "test cuando se crea un carrito inicialmente esta vacio"(){
        given:
            Editorial editorial = new Editorial();
            Carrito carrito = new Carrito(editorial)
        when :
            def amountExpected =carrito.getCantidadLibrosComprados()
        then:
          assert 0==amountExpected
    }


    void "test cuando se agrega un libro y el libro es de la editorial  la cantidad debe ser 1"(){
        given:
            Editorial editorial = new Editorial();
            def book = new Book(titulo:"GOT")
            Carrito carrito = new Carrito(editorial)
        when:
            editorial.addBook(book)
            carrito.addBook(book)
        then:
            assert carrito.getCantidadLibrosComprados()==1

    }

    void "test cuando se desea agregar otro libro del mismo tiulo lo debe permitir"(){
        given:
            Editorial editorial = new Editorial();
            Book got = new Book(titulo:"GOT")
            Book mil = new Book(titulo:"Milenium")
            Utils.addBookToEditorial(got, editorial)
            Utils.addBookToEditorial(mil, editorial)
            Carrito carrito = new Carrito(editorial)
        when:
            carrito.addBook(got);
            carrito.addBook(mil);
            carrito.addBook(new Book(titulo:"GOT"));
        then:
        assert carrito.getCantidadLibrosComprados()==3

    }


    void "test cuando se desea remover un libro, lo descuenta de la cantidad"(){
        given:
            Carrito carrito = Utils.createEnvironment(1);
        when:
        def b = Utils.getBook("1")
        carrito.addBook(b);
        carrito.removeBook(b);
        then:
        assert carrito.getCantidadLibrosComprados()==0

    }

    void "test cuando se desea remover mas veces de lo que se contiene, no deberia afectar"(){
        given:
        Carrito carrito = Utils.createEnvironment(1);
        when:
        def b = Utils.getBook("1")
            carrito.addBook(b);
            carrito.removeBook(b);
            carrito.removeBook(b);
        then:
        assert carrito.getCantidadLibrosComprados()==0

    }



    void "test cuando se desea agregar un libro que no es de la Editorial debe pinchar"(){
        given:
            Carrito carrito = Utils.createEnvironment(1);
        when:
            carrito.addBook(Utils.getBook("unexpected"));
        then:
            Exception e = thrown()
            e.message.equals("No puede agregar este libro al carrito;Libro que no corresponde a la editorial")

    }



}
