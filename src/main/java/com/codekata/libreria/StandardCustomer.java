package com.codekata.libreria;

/**
 * Created by davidgk on 25/07/16.
 */
public class StandardCustomer implements IClient {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
