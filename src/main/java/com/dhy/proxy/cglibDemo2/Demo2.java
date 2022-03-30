package com.dhy.proxy.cglibDemo2;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Project fighting-core
 * @Description 代理有接口的类
 * @Author lvaolin
 * @Date 2022/3/30 上午10:44
 */
public class Demo2 {
    public static void main(String[] args) {
        IPerson person = new CglibFactory<Person,IPerson>().getInstance(Person.class, new MyCglibMethodInterceptor());
        person.eat();
    }

}

class CglibFactory<T,R> {
    public R getInstance(Class<T> target, Callback callback){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(callback);
        return (R)enhancer.create();
    }
}
interface IPerson{
    void eat();
}
class Person implements IPerson{
    @Override
    public void eat(){
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