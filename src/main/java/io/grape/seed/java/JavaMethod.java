package io.grape.seed.java;

import io.papaya.kit.ArrayKit;

/**
 * Created by jamin on 2017/2/6.
 */
public class JavaMethod {

    private final JavaScope scope;
    private final JavaValue.Type returnType;
    private final String name;
    private Param[] params;
    private JavaAnno[] annos;
    private Body body;

    public JavaMethod(JavaValue.Type returnType, String name){
        this(JavaScope.PUBLIC, returnType, name);
    }
    public JavaMethod(JavaScope scope, JavaValue.Type returnType, String name){
        this.scope = scope;
        this.returnType = returnType;
        this.name = name;
    }

    public JavaScope getScope() {
        return scope;
    }

    public JavaValue.Type getReturnType() {
        return returnType;
    }

    public String getName() {
        return name;
    }

    public Param[] getParams() {
        return params;
    }

    public void setParams(Param[] params) {
        this.params = params;
    }

    public JavaAnno[] getAnnos() {
        return annos;
    }

    public void setAnnos(JavaAnno[] annos) {
        this.annos = annos;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(ArrayKit.isNotEmpty(annos)){
            for(JavaAnno anno : annos){
                builder.append("\t").append(anno).append("\n");
            }
        }
        builder.append("\t").append(scope).append(" ").append(returnType).append(" ").append(name).append("(");
        //params
        if(ArrayKit.isNotEmpty(params)){
            int i = 0;
            for(Param param : params){
                builder.append(param);
                if(i < params.length - 1){
                    builder.append(",").append(" ");
                }
                i++;
            }
        }
        builder.append(")");
        if(body != null){
            builder.append(body);
        }else{
            builder.append(";");
        }
        return builder.toString();
    }

    public static class Param {

        private final JavaValue.Type type;
        private final String name;
        private final JavaAnno[] annos;

        public Param(JavaValue.Type type, String name, JavaAnno... annos){
            this.type = type;
            this.name = name;
            this.annos = annos;
        }

        public JavaValue.Type getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public JavaAnno[] getAnnos() {
            return annos;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            if(ArrayKit.isNotEmpty(annos)){
                for(JavaAnno anno : annos){
                    builder.append(anno).append(" ");
                }
            }
            builder.append(type).append(" ").append(name);
            return builder.toString();
        }
    }

    public static class Body {

        private final String[] lines;

        public Body(String[] lines){
            this.lines = lines;
        }

        public String[] getLines() {
            return lines;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{").append("\n");
            for(String line : lines){
                builder.append("\t").append("\t").append(line).append(";").append("\n");
            }
            builder.append("\t").append("}").append("\n");
            return builder.toString();
        }
    }
}
