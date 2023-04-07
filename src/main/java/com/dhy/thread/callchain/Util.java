package com.dhy.thread.callchain;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

public class Util{
        @SneakyThrows
        public static void getCallChain(){
            StringBuilder sb = new StringBuilder("");
            Throwable t = new Throwable();
            StackTraceElement[] stackTrace = t.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                //System.out.println(element.toString());
                sb.append(element.toString()+"->");
                String className = element.getClassName();
                String methodName = element.getMethodName();
                Class<?> myclass = Class.forName(className);
                RequestMapping rm = myclass.getAnnotation(RequestMapping.class);
                String classRp ="";
                if (rm!=null) {
                    classRp = Util.array2string(rm.value());
                }

                Method[] methods = myclass.getDeclaredMethods();
                boolean flag = false ;
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        RequestMapping a = method.getAnnotation(RequestMapping.class);
                        if (a!=null) {
                            sb.append("path："+classRp+Util.array2string(a.value())+"?"+Util.array2string(a.params()));
                            flag = true;
                        }
                    }
                }

                if (flag&&(className.contains("Controller")||className.contains("Action"))) {
                    break;
                }

            }
            System.out.println(sb.toString());
        }

        public  static String array2string(String[] values){
            String value = "";
            for (String v : values) {
                value = value+v;
            }
            return value;
        }
    }