package cn.ylj.proxy;

/**
** 通知类
 */
public class Advice {

    public void preMethod(){
        System.out.println("前置增强方法。。。");
    }

    public void postMethod(){
        System.out.println("后置增强方法。。。");
    }
}