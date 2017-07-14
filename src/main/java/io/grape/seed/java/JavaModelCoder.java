package io.grape.seed.java;//package io.grape.coder.java;
//
//import com.github.autowork.coder.model.*;
//
///**
// * Created by jamin on 2017/2/7.
// */
//public class ModelCoder {
//
//    public String codeModel(Model model){
//        JavaBuilder builder = new JavaBuilder(model.getName());
//        for(ModelField modelField : model.getFields()){
//            JavaValue.Type fieldType = new JavaValue.Type(modelField.getType());
//            JavaField javaField = new JavaField(fieldType, modelField.getName());
//            builder.addField(javaField);
//            builder.addMethod(new JavaGetMethod(javaField));
//            builder.addMethod(new JavaSetMethod(javaField));
//        }
//        return builder.build().toString();
//    }
//
//    public String codeAction(Model model){
//        JavaBuilder builder = new JavaBuilder(model.getName() + "Action");
//        builder.setPackage(model.getPackage());
//        ModelActions actions = model.getActions();
//        builder.addAnno(new JavaValue.Type("org.springframework.web.bind.annotation.RequestMapping"), new JavaAnno.Param("value", new JavaValue(JavaValue.Type.STRING, actions.getRequestPath())));
//        for(ModelAction action : model.getActions().getActions()){
//            JavaMethod method = new JavaMethod(new JavaValue.Type(action.getReturnType()), action.getName());
//
//            method.setAnnos(new JavaAnno[]{
//                new JavaAnno(new JavaValue.Type("org.springframework.web.bind.annotation.RequestMapping"),
//                new JavaAnno.Param("value", new JavaValue(JavaValue.Type.STRING, action.getRequestPath())),
//                new JavaAnno.Param("method", new JavaValue(new JavaValue.Type("org.springframework.web.bind.annotation.RequestMethod"), "POST")))
//            });
//
//            if(action.getParams() != null){
//                int i = 0;
//                JavaMethod.Param[] params = new JavaMethod.Param[action.getParams().size()];
//                for(ModelActionParam actionParam : action.getParams()){
//                    JavaValue.Type type = new JavaValue.Type(actionParam.getType());
//                    JavaMethod.Param param = null;
//                    if(actionParam.getRequestType().equals("BodyParam")){
//                        param = new JavaMethod.Param(new JavaValue.Type(actionParam.getType()),
//                                actionParam.getName(),
//                                new JavaAnno(new JavaValue.Type("RequestBodyParam"), new JavaAnno.Param("name", new JavaValue(JavaValue.Type.STRING, actionParam.getRequestName()))));
//                    }else if(actionParam.getRequestType().equals("Body")){
//                        param = new JavaMethod.Param(type, actionParam.getName(), new JavaAnno(new JavaValue.Type("org.springframework.web.bind.annotation.RequestBody")));
//                    }else if(actionParam.getRequestType().equals("Param")){
//                        param = new JavaMethod.Param(type, actionParam.getName(), new JavaAnno(new JavaValue.Type("org.springframework.web.bind.annotation.RequestParam"), new JavaAnno.Param("name", new JavaValue(JavaValue.Type.STRING, actionParam.getRequestName()))));
//                    }
//                    params[i] = param;
//                    i++;
//                }
//                method.setParams(params);
//            }
//
//            builder.addMethod(method);
//        }
//        return builder.build().toString();
//    }
//
//    public void code(Model model){
//        codeModel(model);
//        System.out.println(codeAction(model));
//    }
//}
