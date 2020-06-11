package com.mycompany.converttobytecode;

import javax.tools.*;

public class GenClass {

    public static void generateClass(String pathName, String fName) {

        System.out.println(System.getProperty("user.dir"));
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        
        int result = compiler.run(null, null, null,
                pathName + fName + ".java"); 
        
        System.out.println("Compile result code = " + result);

    }

    public static void main(String[] args) throws Exception {
        //String pathName = "C:\\Users\\Nano\\Documents\\NetBeansProjects\\ConvertToByteCode\\temp\\";
        //String fName = "sample01";
        //generateClass(pathName, fName);
    }
}
