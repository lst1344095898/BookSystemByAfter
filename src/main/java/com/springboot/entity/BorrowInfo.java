package com.springboot.entity;

public class BorrowInfo {
    private int userid;
    private int bookid;
    private String authorName;
    private String bookName;
    private String educationName;
    private String startTime;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "BorrowInfo{" +
                "userid=" + userid +
                ", bookid=" + bookid +
                ", authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", educationName='" + educationName + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}
