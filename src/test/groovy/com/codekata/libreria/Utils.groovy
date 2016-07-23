package com.codekata.libreria

/**
 * Created by davidgk on 22/07/16.
 */
class Utils {

    static Book getBook(title, price = 10) {
        return new Book(titulo: "libro_"+title , precio: price)
    }

    static def addBookToEditorial(Book book,Editorial editorial) {
        editorial.addBook(book);
    }

    static Carrito createEnvironment(titleAssign, cantidad = 1, BigDecimal price = 10) {
        Editorial editorial = new Editorial();
        for (int i = 1; i < titleAssign + 1; i++) {
            for (int j = 0; j < cantidad; j++) {
                Book got = getBook(i,price)
                addBookToEditorial(got, editorial)
            }

        }
        return new Carrito(editorial)
    }
}
