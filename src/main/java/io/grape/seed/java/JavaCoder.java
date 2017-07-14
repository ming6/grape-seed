//package io.grape.seed.java;
//
//import io.papaya.ext.velocity.VelocityKit;
//import io.papaya.kit.ResourceKit;
//import org.apache.velocity.VelocityContext;
//
//import java.io.File;
//
///**
// * Created by jamin on 2017/2/6.
// */
//public class JavaCoder {
//
//    public void code(Java java){
//        VelocityContext context = new VelocityContext();
//        context.put("java", java);
//        File template = ResourceKit.getClassPathFile("java/java.vm");
//        File output = new File("e://a/App.java");
//        VelocityKit.renderFile(context, template, output);
//    }
//}
