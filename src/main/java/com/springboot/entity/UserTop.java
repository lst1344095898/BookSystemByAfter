package com.springboot.entity;

public class UserTop {
    private String userName;
    private int borrowTimes;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBorrowTimes() {
        return borrowTimes;
    }

    public void setBorrowTimes(int borrowTimes) {
        this.borrowTimes = borrowTimes;
    }

    @Override
    public String toString() {
        return "UserTop{" +
                "userName='" + userName + '\'' +
                ", borrowTimes=" + borrowTimes +
                '}';
    }
}
