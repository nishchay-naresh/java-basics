package com.nishchay.java8.streams.flatmap;

public class Book
{
    private int bookId;
    private String name;
    private String authorName;
    private int pageCount;

    public Book(int bookId, String name, String authorName, int pageCount) {
        this.bookId = bookId;
        this.name = name;
        this.authorName = authorName;
        this.pageCount = pageCount;
    }

    public int getBookId()
    {
        return bookId;
    }
    public void setBookId(int bookId)
    {
        this.bookId = bookId;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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
}
