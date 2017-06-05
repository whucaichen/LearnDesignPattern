package com.chance;

/**
 * Created by Chance on 2016/7/20.
 */
public class YAMLFormatter extends Formatter {

    @Override
    protected String formating(Book book) {
        String result = "";
        result += "book_name: " + book.getBookName() + "\n";
        result += "pages: " + book.getPages() + "\n";
        result += "price: " + book.getPrice() + "\n";
        result += "author: " + book.getAuthor() + "\n";
        result += "isbn: " + book.getIsbn() + "\n";
        return result;
    }
}
