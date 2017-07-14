package io.grape.seed.java;

import io.papaya.kit.ArrayKit;

/**
 * Created by jamin on 2017/2/6.
 */
public class JavaField {

    private final JavaScope scope;
    private final JavaValue.Type type;
    private final String name;
    private JavaAnno[] annos;

    public JavaField(JavaValue.Type type, String name){
        this(JavaScope.PRIVATE, type, name);
    }
    public JavaField(JavaScope scope, JavaValue.Type type, String name){
        this.scope = scope;
        this.type = type;
        this.name = name;
    }

    public JavaScope getScope() {
        return scope;
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

    public void setAnnos(JavaAnno[] annos) {
        this.annos = annos;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(ArrayKit.isNotEmpty(annos)){
            for(JavaAnno anno : annos){
                builder.append(anno).append("\n");
            }
        }
        builder.append(scope);
        if(!JavaScope.DEFAULT.equals(scope)){
            builder.append(" ");
        }
        builder.append(type).append(" ");
        builder.append(name).append(";");
        return builder.toString();
    }

//    public static class Type {
//
//        private final String name;
//        private final String simpleName;
//        private Type generics;
//
//        public Type(String name){
//            this.name = name;
//            int index = name.lastIndexOf(".");
//            if(index == -1){
//                this.simpleName = name;
//            }else{
//                this.simpleName = name.substring(index + 1);
//            }
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public String getSimpleName() {
//            return simpleName;
//        }
//
//        public Type getGenerics() {
//            return generics;
//        }
//
//        public void setGenerics(Type generics) {
//            this.generics = generics;
//        }
//
//        @Override
//        public String toString() {
//            StringBuilder builder = new StringBuilder();
//            builder.append(simpleName);
//            if(generics != null){
//                builder.append("<").append(generics.getSimpleName()).append(">");
//            }
//            return builder.toString();
//        }
//    }

//    public static class Value {
//
//        private Object value;
//
//        public Value(Object value){
//            this.value = value;
//        }
//
//        @Override
//        public String toString() {
//            if(value instanceof String){
//                return "\"" + value + "\"";
//            }
//            return String.valueOf(value);
//        }
//    }
}
