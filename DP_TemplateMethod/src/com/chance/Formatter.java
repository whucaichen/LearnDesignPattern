package com.chance;

/**
 * Created by Chance on 2016/7/20.
 */
public abstract class Formatter {

    public String formatBook(Book book) {
        beforeFormat();
        String result = formating(book);
        afterFormat();
        return result;
    }

    protected void beforeFormat() {
        System.out.println("format begins");
    }

    protected abstract String formating(Book book);

    protected void afterFormat() {
        System.out.println("format finished");
    }
}
