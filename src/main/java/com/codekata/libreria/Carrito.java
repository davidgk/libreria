package com.codekata.libreria;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by davidgk on 22/07/16.
 */
public class Carrito {
    private Map<String,List<Book>> listaCompras;
    private Editorial editorial;
    public Carrito(Editorial editorial){
        this.editorial = editorial;
        this.listaCompras = new HashMap<String, List<Book>>();
    }

    public int getCantidadLibrosComprados() {
        Set<String> keyset = this.listaCompras.keySet();
        int amount =0;
        for (String key : keyset) {
            amount += listaCompras.get(key).size();
        }
        return amount;

    }

    public void addBook(final Book book) throws Exception{
        validateBookBelongsEditorial(book);
        if(this.listaCompras.keySet().contains(book.titulo)){
            this.listaCompras.get(book.titulo).add(book);
            return;
        }
        List put =new ArrayList<Book>();
        put.add(book);
        this.listaCompras.put(book.titulo, put);
    }

    private void validateBookBelongsEditorial(Book book) throws Exception {
        if(!this.editorial.contains(book))
            throw new Exception("No puede agregar este libro al carrito;Libro que no corresponde a la editorial");
    }

    public void removeBook(Book book) throws Exception {
        if(this.listaCompras.keySet().contains(book.titulo)&&(this.listaCompras.get(book.titulo).size()>0)){
            this.listaCompras.get(book.titulo).remove(book) ; return ;
        }

    }


    public BigDecimal checkout() {
        Double totalamount = 0D;
        for (String title :listaCompras.keySet()){
            List<Book> compradosPorTitulo = listaCompras.get(title);
            totalamount+=compradosPorTitulo
                    .stream()
                    .mapToDouble(Book::getPrecio).sum();
        }
        return new BigDecimal(totalamount);
    }
}