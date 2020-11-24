package com.pizza.domain.input;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public abstract class SelectContent<T> {
    protected static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();
    protected static final Scanner SCANNER = new Scanner(System.in);

    protected final List<T> contents;

    SelectContent(final List<T> contents) {
        this.contents = contents;
    }

    abstract T get();
}
