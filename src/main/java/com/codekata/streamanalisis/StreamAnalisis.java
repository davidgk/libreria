package com.codekata.streamanalisis;

import com.codekata.libreria.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by davidgk on 28/07/16.
 */
public class StreamAnalisis {


    public Integer doStream(List<Book> list, List<Book> booksToAdd) {
        List<Book> books = list;
        Optional<List<Book>> listBooksToAdd = Optional.ofNullable(booksToAdd);
        listBooksToAdd.ifPresent(withBooks -> withBooks.stream().forEach(book -> books.add(book)));
        return books.size();
    }
}
