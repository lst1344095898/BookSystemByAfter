package com.springboot.entity;

public class UserLog {
    private String userid;
    private String userName;
    private String power;
    private String log_datetime;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getLog_datetime() {
        return log_datetime;
    }

    public void setLog_datetime(String log_datetime) {
        this.log_datetime = log_datetime;
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "userid='" + userid + '\'' +
                ", userName='" + userName + '\'' +
                ", power='" + power + '\'' +
                ", log_datetime='" + log_datetime + '\'' +
                '}';
    }
}
