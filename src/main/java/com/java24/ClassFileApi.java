package com.java24;

import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.MethodModel;

public class ClassFileApi {

    public static double payable(double mrp) {
        return mrp;
    }

    public static void main(String[] args) throws Exception {
        try (var bytes = ClassFileApi.class.getResourceAsStream("ClassFileApi.class")) {
            if (bytes == null) {
                System.out.println("Compile first so the .class file is on the classpath.");
                return;
            }

            ClassModel model = ClassFile.of().parse(bytes.readAllBytes());
            System.out.println("Auditing class: " + model.thisClass().asSymbol().displayName());
            System.out.println("Methods exposed to the pricing engine:");
            for (MethodModel method : model.methods()) {
                System.out.println("  - " + method.methodName().stringValue());
            }
        }
    }
}
