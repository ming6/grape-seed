package io.grape.seed.java;

/**
 * Created by jamin on 2017/2/6.
 */
public class JavaBuilder {

    private Java java;

    public JavaBuilder(String name){
        this(JavaType.CLASS, name);
    }
    public JavaBuilder(JavaType type, String name){
        this(JavaScope.PUBLIC, type, name);
    }
    public JavaBuilder(JavaScope scope, JavaType type, String name){
        this.java = new Java(scope, type, name);
    }

    public JavaBuilder setPackage(String _package){
        this.java.setPackage(_package);
        return this;
    }

    public JavaBuilder addImport(String _import){
        this.java.addImport(_import);
        return this;
    }

    public JavaBuilder addAnno(JavaValue.Type type, JavaAnno.Param... params){
        this.java.addAnno(new JavaAnno(type, params));
        return this;
    }

    public JavaBuilder addField(JavaValue.Type type, String name){
        return addField(type, name, null);
    }
    public JavaBuilder addField(JavaValue.Type type, String name, JavaAnno[] annos){
        return addField(JavaScope.PUBLIC, type, name, annos);
    }
    public JavaBuilder addField(JavaScope scope, JavaValue.Type type, String name, JavaAnno[] annos){
        JavaField field = new JavaField(scope, type, name);
        field.setAnnos(annos);
        return addField(field);
    }
    public JavaBuilder addField(JavaField field){
        this.java.addField(field);
        return this;
    }

    public JavaBuilder addMethod(JavaValue.Type returnType, String name){
        return addMethod(returnType, name, null, null);
    }
    public JavaBuilder addMethod(JavaValue.Type returnType, String name, JavaMethod.Param[] params){
        return addMethod(returnType, name, params, null);
    }
    public JavaBuilder addMethod(JavaValue.Type returnType, String name, JavaMethod.Body body){
        return addMethod(returnType, name, null, body);
    }
    public JavaBuilder addMethod(JavaValue.Type returnType, String name, JavaMethod.Param[] params, JavaMethod.Body body){
        return addMethod(returnType, name, params, body, null);
    }
    public JavaBuilder addMethod(JavaValue.Type returnType, String name, JavaMethod.Param[] params, JavaMethod.Body body, JavaAnno[] annos){
        return addMethod(JavaScope.PUBLIC, returnType, name, params, body, annos);
    }
    public JavaBuilder addMethod(JavaScope scope, JavaValue.Type returnType, String name, JavaMethod.Param[] params, JavaMethod.Body body, JavaAnno[] annos){
        JavaMethod method = new JavaMethod(scope, returnType, name);
        method.setParams(params);
        method.setAnnos(annos);
        method.setBody(body);
        return addMethod(method);
    }
    public JavaBuilder addMethod(JavaMethod method){
        this.java.addMethod(method);
        return this;
    }

    public JavaBuilder addJava(Java java){
        this.java.addJava(java);
        return this;
    }

    public Java build(){
        return java;
    }
}
