package com.springboot.entity;

public class Paging<T> {
    private boolean state_id;
    private T data;
    private String error;
    private String pages;

    public boolean getState_id() {
        return state_id;
    }
    public void setState_id(boolean state_id) {
        this.state_id = state_id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "state_id=" + state_id +
                ", data=" + data +
                ", error='" + error + '\'' +
                ", pages=" + pages +
                '}';
    }
}
