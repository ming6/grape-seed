package io.grape.seed.java;

import io.papaya.kit.ArrayKit;
import io.papaya.kit.CollectionKit;
import io.papaya.kit.StringKit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jamin on 2017/2/6.
 */
public class Java {

    private String _package;
    private final Set<String> imports = new HashSet<>();
    private JavaScope scope;
    private JavaStatus status;
    private JavaType type;
    private String name;
    private final List<JavaField> fields = new ArrayList<>();
    private final List<JavaMethod> methods = new ArrayList<>();
    private final List<JavaAnno> annos = new ArrayList<>();
    private final List<Java> javas = new ArrayList<>();

    public Java(String name){
        this(JavaScope.PUBLIC, JavaType.CLASS, name);
    }
    public Java(JavaType type, String name){
        this(JavaScope.PUBLIC, type, name);
    }
    public Java(JavaScope scope, JavaType type, String name){
        setScope(scope);
        setType(type);
        setName(name);
    }

    public String getPackage() {
        return _package;
    }

    public void setPackage(String _package) {
        this._package = _package;
    }

    public Set<String> getImports() {
        return imports;
    }

    public void addImport(String _import) {
        this.imports.add(_import);
    }

    public JavaScope getScope() {
        return scope;
    }

    public void setScope(JavaScope scope) {
        this.scope = scope;
    }

    public JavaStatus getStatus() {
        return status;
    }

    public void setStatus(JavaStatus status) {
        this.status = status;
    }

    public JavaType getType() {
        return type;
    }

    public void setType(JavaType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JavaField> getFields() {
        return fields;
    }

    public void addField(JavaField field) {
        this.fields.add(field);
        //import field type
        this.imports.addAll(field.getType().getImports());
        //import field anno type
        if(ArrayKit.isNotEmpty(field.getAnnos())){
            for(JavaAnno anno : field.getAnnos()){
                this.imports.addAll(anno.getType().getImports());
                //import field anno value type
                for(JavaAnno.Param param : anno.getParams()){
                    this.imports.addAll(param.getValue().getType().getImports());
                }
            }
        }
    }

    public List<JavaMethod> getMethods() {
        return methods;
    }

    public void addMethod(JavaMethod method) {
        this.methods.add(method);
        //import method return type
        imports.addAll(method.getReturnType().getImports());
        //import method param type
        if(ArrayKit.isNotEmpty(method.getParams())){
            for(JavaMethod.Param param : method.getParams()){
                imports.addAll(param.getType().getImports());
            }
        }
        //import method anno type
        if(ArrayKit.isNotEmpty(method.getAnnos())){
            for(JavaAnno anno : method.getAnnos()){
                this.imports.addAll(anno.getType().getImports());
                //import method anno value type
                for(JavaAnno.Param param : anno.getParams()){
                    this.imports.addAll(param.getValue().getType().getImports());
                }
            }
        }
    }

    public List<JavaAnno> getAnnos() {
        return annos;
    }

    public void addAnno(JavaAnno anno) {
        this.annos.add(anno);
        //import anno type
        this.imports.addAll(anno.getType().getImports());
        //import anno value type
        for(JavaAnno.Param param : anno.getParams()){
            this.imports.addAll(param.getValue().getType().getImports());
        }
    }

    public List<Java> getJavas() {
        return javas;
    }

    public void addJava(Java java){
        this.javas.add(java);
        this.imports.addAll(java.getImports());
        java.imports.clear();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        //package
        if(StringKit.isNotBlank(_package)){
            builder.append("package").append(" ").append(_package).append(";").append("\n");
        }
        //imports
        for(String _import : imports){
            builder.append("import").append(" ").append(_import).append(";").append("\n");
        }
        builder.append("\n");
        //annotations
        for(JavaAnno anno : annos){
            builder.append(anno).append("\n");
        }
        if(scope != null){
            builder.append(scope).append(" ");
        }
        if(status != null){
            builder.append(status).append(" ");
        }
        builder.append(type).append(" ").append(name).append("{").append("\n");
        //fields
        if(CollectionKit.isNotEmpty(fields)){
            builder.append("\n");
            for(JavaField field : fields){
                builder.append("\t").append(field).append("\n");
            }
        }
        //methods
        if(CollectionKit.isNotEmpty(methods)){
            builder.append("\n");
            int i = 0;
            for(JavaMethod method : methods){
                builder.append(method);
                if(i < methods.size() - 1){
                    builder.append("\n");
                }
            }
        }
        //javas
        if(CollectionKit.isNotEmpty(javas)){
            builder.append("\n");
            for(Java java : javas){
                builder.append(getAddTabContent(java.toString())).append("\n");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    private String getAddTabContent(String content){
        return StringKit.appendAfter(content, "\n", "\t");
    }
}
