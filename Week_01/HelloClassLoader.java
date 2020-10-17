package com.jkhomework.work.class1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author ：huabin
 * @date ：Created in 2020/10/17 15:20
 * @description：自定义类加载器
 * @modified By：
 * @version: 1.0.0$
 */
public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) {
        try {
            Class<?> hClass = new HelloClassLoader().findClass("Hello");
            Object obj = hClass.newInstance();
            Method method = hClass.getMethod("hello", null);
            method.invoke(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get("D:\\JKStudy\\JKHomeWork\\src\\main\\java\\com\\jkhomework\\work\\class1\\Hello.xlass"));
            for (int i = 0; i < bytes.length; i++) {
                byte a = (byte) (255 - bytes[i]);
                bytes[i] = a;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

}
