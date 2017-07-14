package io.grape.seed.java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jamin on 2017/2/8.
 */
public class JavaValue {

    private final Type type;
    private final Object value;

    public JavaValue(Type type, Object value){
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(type.equals(Type.STRING)){
            builder.append("\"").append(value).append("\"");
        }else if(type.equals(Type.INT) || type.equals(Type.INTEGER)){
            builder.append(value);
        }else{
            builder.append(type).append(".").append(value);
        }
        return builder.toString();
    }

    public static class Type {

        public static final Type VOID = new Type("void");
        public static final Type STRING = new Type("String");
        public static final Type INT = new Type("int");
        public static final Type INTEGER = new Type("Integer");

        private final Set<String> imports = new HashSet<>();

        private final String name;
        private final String simpleName;
        private final Type generics;

        /**
         * name = java.util.List<model.User>
         * simpleName = List
         * generics = { name : model.User, simpleName : User }
         * */
        public Type(String name){
            this.name = name;
            String _name = null;
            //generics
            if(name.contains("<") && name.contains(">")){
                int ltIndex = name.lastIndexOf("<");
                int gtIndex = name.lastIndexOf(">");
                this.generics = new Type(name.substring(ltIndex + 1, gtIndex));
                _name = name.substring(0, ltIndex);
            }else{
                this.generics = null;
                _name = name;
            }
            //simpleName
            int index = _name.lastIndexOf(".");
            if(index != -1){
                this.simpleName = _name.substring(index + 1);
                imports.add(_name);
            }else{
                this.simpleName = _name;
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

        public Set<String> getImports() {
            return imports;
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
