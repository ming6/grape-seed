package io.grape.seed.java;

/**
 * Created by jamin on 2017/2/6.
 */
public enum JavaScope {

    PUBLIC("public"),
    PRIVATE("private"),
    PROTECTED("protected"),
    DEFAULT("");

    private String value;

    JavaScope(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
