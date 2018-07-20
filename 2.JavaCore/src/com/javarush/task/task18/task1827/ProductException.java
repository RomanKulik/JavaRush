package com.javarush.task.task18.task1827;

public class ProductException extends Exception {
    private String message;

    public ProductException() {
        super();
    }

    public ProductException(String message) {
        super(message);
    }
}
