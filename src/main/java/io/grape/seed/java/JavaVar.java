package io.grape.seed.java;

/**
 * Created by jamin on 2017/2/7.
 */
public class JavaVar {

    private Type type;
    private String name;
    private Object value;

    public static class Type {

        public static final String STRING = "String";
        public static final String CLASS = "Class";
        public static final String ENUM = "Enum";

        private final String name;
        private final String simpleName;
        private Type generics;

        public Type(String name){
            this.name = name;
            int index = name.lastIndexOf(".");
            if(index == -1){
                this.simpleName = name;
            }else{
                this.simpleName = name.substring(index + 1);
            }
        }

        public String getName() {
            return name;
        }

        public String getSimpleName() {
            return simpleName;
        }

        public Type getGenerics() {
            return generics;
        }

        public void setGenerics(Type generics) {
            this.generics = generics;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(simpleName);
            if(generics != null){
                builder.append("<").append(generics.getSimpleName()).append(">");
            }
            return builder.toString();
        }
    }
}
