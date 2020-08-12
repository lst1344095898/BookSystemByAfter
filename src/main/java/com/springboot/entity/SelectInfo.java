package com.springboot.entity;

public class SelectInfo {
    private String userid;
    private String bookid;
    private String authorName;
    private String bookName;
    private String educationName;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
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

    @Override
    public String toString() {
        return "BookInfo{" +
                "userid='" + userid + '\'' +
                ", bookid='" + bookid + '\'' +
                ", authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", educationName='" + educationName + '\'' +
                '}';
    }
}
