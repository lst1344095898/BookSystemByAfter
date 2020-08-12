package com.springboot.entity;

public class Book {
    private int bookid;
    private String authorName;
    private String bookName;
    private String educationName;
    private int quantity;

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", educationName='" + educationName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
