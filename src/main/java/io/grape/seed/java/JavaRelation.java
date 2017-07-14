package io.grape.seed.java;

/**
 * Created by jamin on 2017/2/9.
 */
public enum JavaRelation {

    EXTEND("extends"),
    IMPLEMENT("implements");

    private final String value;

    JavaRelation(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
