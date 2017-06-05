package com.chance;

/**
 * Created by Chance on 2016/7/20.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Book book = new Book();
        book.setBookName("Thinking in Java");
        book.setPages(880);
        book.setPrice(68);
        book.setAuthor("Bruce Eckel");
        book.setIsbn("9787111213826");
        XMLFormatter xmlFormatter = new XMLFormatter();
        String result = xmlFormatter.formatBook(book);
        System.out.println(result);
        JSONFormatter jsonFormatter = new JSONFormatter();
        result = jsonFormatter.formatBook(book);
        System.out.println(result);
        YAMLFormatter yamlFormatter = new YAMLFormatter();
        result = yamlFormatter.formatBook(book);
        System.out.println(result);

    }
}
