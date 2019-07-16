package com.nightstory.mineboot.main;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class StringOomMock {
//    static String  base = "string";
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        for (int i=0;i< Integer.MAX_VALUE;i++){
//            String str = base + base;
//            base = str;
//            list.add(str.intern());
//        }
//    }

    public static void main(String[] args) {
        String path = StringOomMock.class.getResource("/").getPath();

        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File(path).toURI().toURL();
            URL[] urls = {url};
            while (true) {
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                Class<?> aClass = loader.loadClass("com.nightstory.mineboot.bean.Student");
                Object o = aClass.newInstance();
                aClass.getMethod("test").invoke(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}