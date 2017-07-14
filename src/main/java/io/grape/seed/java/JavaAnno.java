package io.grape.seed.java;

import io.papaya.kit.ArrayKit;

/**
 * Created by jamin on 2017/2/6.
 */
public class JavaAnno {

    private final JavaValue.Type type;
    private final Param[] params;

    public JavaAnno(JavaValue.Type type, Param... params){
        this.type = type;
        this.params = params;
    }

    public JavaValue.Type getType() {
        return type;
    }

    public Param[] getParams() {
        return params;
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder("@" + type);
        if(ArrayKit.isNotEmpty(params)){
            content.append("(");
            int i = 0;
            for(Param param : params){
                content.append(param);
                if(i < params.length - 1){
                    content.append(",").append(" ");
                }
                i++;
            }
            content.append(")");
        }
        return content.toString();
    }

    public static class Param {

        private final String name;
        private final JavaValue value;

        public Param(String name, JavaValue value){
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public JavaValue getValue() {
            return value;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(name).append("=").append(value);
            return builder.toString();
        }
    }
}
