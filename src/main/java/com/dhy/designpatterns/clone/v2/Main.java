package com.dhy.designpatterns.clone.v2;

/**
 * @Title 深克隆
 * @Description
 * @Author lvaolin
 * @Date 2022/2/6 20:08
 **/
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Address address = new Address();
        address.location = "beijing";

        User user = new User();
        user.id = "id1";
        user.name = "name1";
        user.address = address;

        System.out.println("user:"+user.id);
        System.out.println("user:"+user.name);
        System.out.println("user:"+user.address.location);
        //-------------------------------------------------
        User clone =(User) user.clone();
        System.out.println("clone:"+clone.id);
        System.out.println("clone:"+clone.name);
        System.out.println("clone:"+clone.address.location);

        //-----修改clone的属性
        clone.id = "clone id";
        clone.name = "clone name";
        clone.address.location = "shanghai";

        //--------------user 中的address 没有被改变 说明是深克隆------------------

        System.out.println("user:"+user.id);
        System.out.println("user:"+user.name);
        System.out.println("user:"+user.address.location);
        System.out.println(clone.address == user.address);

    }
}

//需要实现Cloneable 接口才能使用 clone方法
class User implements Cloneable{
    String id;
    String name;

    Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User clone = (User) super.clone();
        clone.address = (Address) address.clone();
        return clone;
    }
}

class Address implements Cloneable{
     String location;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}