package io.grape.seed.java;

/**
 * Created by jamin on 2017/2/6.
 */
public enum JavaType {

    INTERFACE("interface"),
    CLASS("class"),
    INNER_CLASS("class");

    private String value;

    JavaType(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
