package io.grape.seed.java;

/**
 * Created by jamin on 2017/2/9.
 */
public enum JavaStatus {

    STATIC("static"),
    FINAL("final"),
    STATIC_FINAL("static final");

    private String value;

    JavaStatus(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
