package com.future.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tianFeng
 * @version 1.0, 2018/02/08
 */

public class VolatileTest {


    public static void main(String[] args) {

    }


}

class Singleton {
    private Singleton() {}  //私有构造函数
    // volatile 阻止了变量访问前后的指令重排()
    private volatile static Singleton instance = null;  //单例对象
    //静态工厂方法
    public static Singleton getInstance() {
        if (instance == null) {      //双重检测机制
            synchronized (Singleton.class){  //同步锁
                if (instance == null) {     //双重检测机制
                    instance = new Singleton();
                    // memory = allocate(); //1：分配对象的内存空间

                    // ctorInstance(memory); //2：初始化对象

                    // instance = memory; //3：设置instance指向刚分配的内存地址
                }
            }
        }
        return instance;
    }
}


