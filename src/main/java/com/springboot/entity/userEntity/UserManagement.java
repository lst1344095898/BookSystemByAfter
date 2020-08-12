package com.springboot.entity.userEntity;

public class UserManagement {
    private int userid;
    private String username;
    private int  page;
    private int  count;
    private String pageNew;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getPageNew() {
        return pageNew;
    }

    public void setPageNew(String pageNew) {
        this.pageNew = pageNew;
    }

    @Override
    public String toString() {
        return "UserManagement{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", page=" + page +
                ", count=" + count +
                ", pageNew='" + pageNew + '\'' +
                '}';
    }
}
