/**
 * @Project fighting-core
 * @Description
 *
 * 有这么一个问题：
 * synchronized修饰静态方法时用的类锁存在在什么位置？
 * 答案是在 Class类实例的Markword 里。
 * 你可能会问 Markword不是对象头里的东西吗？ 那么元数据区的类里也有这个东西吗？
 * 要想明白这个问题就需要理解 java.lang.Class  和 java.lang.Object 这两个类
 *
 * Class类是用来表示 类结构信息的元数据类，那么每一个被加载到元数据区的类都是Class类的实例，
 * 在Java中Object类是所有类的父类，所以Class类也不例外，它也是Object 类的子类，
 * Class类的实例也是对象，也有对象头，也有Markword，也可以记录 锁的信息；
 *
 * Class类本身没有公开的构造方法，只有一个带参数的构造方法
 *
 *   private Class(ClassLoader loader) {
 *         // Initialize final field for classLoader.  The initialization value of non-null
 *         // prevents future JIT optimizations from assuming this final field is null.
 *         classLoader = loader;
 *     }
 *
 * 那么得到Class类的实例的方法有：
 *
 * 1、类加载器加载一个类文件到内存
 * 2、通过 Class c = ReentrantLock.class;
 * 3、obj.getClass()
 *
 * 为什么平时可以用反射获取到类的元数据信息？
 *
 * 就是因为 每一个类的的定义信息 都是以对象的形式 存在于 元数据区，
 * 当你 obj.getClass() 时就会得到那个对象的指针，
 * 进而访问这个对象里所有的数据信息，这里的数据就是 描述一个类定义信息的元数据。
 * 结合Java提供的 反射API就可以做很多用普通方式无法做的事情
 *
 *
 * @Author lvaolin
 * @Date 2022/3/27 下午2:01
 */
package com.dhy.classAndObject;