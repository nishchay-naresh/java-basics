package com.nishchay.util.pojo;

import java.util.Arrays;
import java.util.List;

public class Book {
    private int bookId;
    private String name;
    private String authorName;
    private int pageCount;


    public Book() {
    }

    public Book(int bookId, String name, String authorName, int pageCount) {
        this.bookId = bookId;
        this.name = name;
        this.authorName = authorName;
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public static List<Book> getListOfBook() {
        return Arrays.asList(
                new Book(1011, "Hindi", "Prem Chand", 200),
                new Book(1012, "Mathematics", "K C Sinha", 650),
                new Book(1033, "Computer Science", "Tenen Bom", 140),
                new Book(1048, "Physics", "H C Verma", 240),
                new Book(1050, "Economics", "Rowrds Jowney", 900)
        );
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

    public String getAuthorName() {
        return authorName;
    }
}
