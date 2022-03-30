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
        IPerson person = CglibFactory.getProxy(Person.class, new MyCglibMethodInterceptor(),null,null);
        person.eat();
    }

}

class CglibFactory {
    public static<T,R> R getProxy(Class<T> target, Callback callback, Class[] argumentTypes, Object[] arguments){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(callback);
        if (argumentTypes!=null&&arguments!=null) {
            //有参构造器
            return (R)enhancer.create(argumentTypes,arguments);
        }else{
            //无参构造器
            return (R)enhancer.create();
        }

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