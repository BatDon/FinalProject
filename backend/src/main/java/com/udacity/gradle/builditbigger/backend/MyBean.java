package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String joke;

    public String getMyBeanJoke() {
        return joke;
    }

    public void setData(String data) {
        joke = data;
    }
}