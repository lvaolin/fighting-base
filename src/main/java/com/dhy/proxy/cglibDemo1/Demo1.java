package com.dhy.proxy.cglibDemo1;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Project fighting-core
 * @Description 代理没有接口的类
 * @Author lvaolin
 * @Date 2022/3/30 上午10:30
 */
public class Demo1 {
    public static void main(String[] args) {
//        Person person = (Person)CglibFactory.getInstance(Person.class, new MyCglibMethodInterceptor());
//        person.eat();

        Person instance = new CglibFactory<Person>().getInstance(Person.class, new MyCglibMethodInterceptor());
        instance.eat();
    }
}

class CglibFactory<T> {
    public T getInstance(Class<T> target, Callback callback){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(callback);
        return (T)enhancer.create();
    }
}

class Person {
    void eat(){
        System.out.println("吃饭");
    }
}

class MyCglibMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我饭前洗手");
        //System.out.println(method.getName());
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("我饭后漱口");
        return result;
    }

}