package io.grape.seed.java;

import io.papaya.kit.StringKit;

/**
 * Created by jamin on 2017/2/7.
 */
public class JavaGetMethod extends JavaMethod {

    public JavaGetMethod(JavaField field) {
        super(field.getType(), "get" + StringKit.uppercaseFirstLetter(field.getName()));
        setBody(new JavaMethod.Body(new String[]{
            "return this." + field.getName()
        }));
    }
}
