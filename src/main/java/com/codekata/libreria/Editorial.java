package com.codekata.libreria;

import java.util.*;

/**
 * Created by davidgk on 22/07/16.
 */
public class Editorial {


    private Map catalogoPorTitulo;

    public Editorial(){
        this.catalogoPorTitulo = new HashMap<String, Book>();
    }

    public void addBook(final Book book) {
        if(this.catalogoPorTitulo.keySet().contains(book.titulo)){
            return;
        }
        this.catalogoPorTitulo.put(book.titulo, book);
    }

    public boolean contains(Book book) {
        return this.catalogoPorTitulo.keySet().contains(book.titulo);
    }
}
