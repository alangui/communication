package com.qing.niu.workstation.web.jdk.jvm.classloader;

import java.io.*;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/18 16:42
 * @ProjectName communication
 * @Version 1.0.0
 */
public class CustomizeClassLoader extends ClassLoader{
    private String classLoadName;

    private final String fileExtension = ".class";

    private String path;

    public CustomizeClassLoader(String classLoadName){
        super();
        this.classLoadName = classLoadName;
    }

    public CustomizeClassLoader(ClassLoader classLoader){
        super(classLoader);
    }

    public CustomizeClassLoader(ClassLoader classLoader, String classLoadName){
        super(classLoader);
        this.classLoadName = classLoadName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println(classLoadName + ".findClass");
        byte[] data = this.loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }

    private byte[] loadClassData(String className){
        System.out.println("loadClassData ..." + className);
        InputStream inputStream = null;
        byte[] data = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            className = className.replace(".","/");
            inputStream = new FileInputStream(new File(this.path + className + this.fileExtension));
            byteArrayOutputStream = new ByteArrayOutputStream();

            int ch = 0;
            while (-1 != (ch = inputStream.read())){
                byteArrayOutputStream.write(ch);
            }
            data = byteArrayOutputStream.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    @Override
    public String toString() {
        return "Test10{" +
                "classLoadName='" + classLoadName + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }

}
