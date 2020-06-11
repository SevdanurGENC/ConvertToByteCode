package com.mycompany.converttobytecode;

import java.io.File;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.InstructionPrinter;
import java.io.FileInputStream;
import java.io.PrintStream;

/**
 *
 * @author Nano
 */
public class ByteCodeEditor {

    public static ClassPool _classPool = ClassPool.getDefault();

    public static void Main(String filePath, String FileName) throws Exception {
        String filePathFull = filePath + FileName + ".class";

        PrintStream o = new PrintStream(new File(filePath + FileName + "_ByteCode.txt"));
        PrintStream console = System.out;
        System.setOut(o);

        ByteCodeEditor _byteCodeEditor = new ByteCodeEditor();
        CtClass _ctClass = _classPool.makeClass(new FileInputStream(filePathFull));

        _byteCodeEditor.printMethodCode(_ctClass);

        System.setOut(console);
    }

    public static void printMethodCode(CtClass _ctClass) throws Exception {
        PrintStream ps = new PrintStream(System.out);
        InstructionPrinter instructionPrinter = new InstructionPrinter(ps);
        for (CtMethod method : _ctClass.getDeclaredMethods()) {
            System.out.println("MethodName : " + method.getName());
            instructionPrinter.print(method);
        }
    }
}
