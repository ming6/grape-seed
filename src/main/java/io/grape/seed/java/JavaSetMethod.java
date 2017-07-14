package io.grape.seed.java;

import io.papaya.kit.StringKit;

/**
 * Created by jamin on 2017/2/7.
 */
public class JavaSetMethod extends JavaMethod {

    public JavaSetMethod(JavaField field) {
        super(JavaValue.Type.VOID, "set" + StringKit.uppercaseFirstLetter(field.getName()));
        setParams(new JavaMethod.Param[]{
            new JavaMethod.Param(field.getType(), field.getName())
        });
        setBody(new JavaMethod.Body(new String[]{
            "this." + field.getName() + "=" + field.getName()
        }));
    }
}
