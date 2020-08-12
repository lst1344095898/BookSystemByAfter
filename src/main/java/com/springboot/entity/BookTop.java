package com.springboot.entity;

public class BookTop {
    private String bookName;
    private String authorName;
    private int borrowTimes;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getBorrowTimes() {
        return borrowTimes;
    }

    public void setBorrowTimes(int borrowTimes) {
        this.borrowTimes = borrowTimes;
    }

    @Override
    public String toString() {
        return "BookTop{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", borrowTimes=" + borrowTimes +
                '}';
    }
}
