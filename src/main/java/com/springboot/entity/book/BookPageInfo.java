package com.springboot.entity.book;

public class BookPageInfo {
    private int  page;
    private int  count;
    private int  bookid;
    private String authorName;
    private String bookName;
    private String educationName;
    private String quantity;
    private String pageNew;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPageNew() {
        return pageNew;
    }

    public void setPageNew(String pageNew) {
        this.pageNew = pageNew;
    }

    @Override
    public String toString() {
        return "BookPageInfo{" +
                "page=" + page +
                ", count=" + count +
                ", bookid=" + bookid +
                ", authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", educationName='" + educationName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", pageNew='" + pageNew + '\'' +
                '}';
    }
}
