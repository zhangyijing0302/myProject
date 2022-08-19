package com.myProject.company.xyxx;

/**
 * 考虑静态内部类实现
 *
 * <p>功能: 编写单例模式的程序
 */
public class SingletonCase {

    private SingletonCase(String name) {
    }

    /**
     * 要做的事情，比如只存一个叫张三的姓名
     */
    private String userName;

    static class SingletonInstance {
        static SingletonCase instance = new SingletonCase("张三");
    }

    public static SingletonCase getInstance() {
        return SingletonInstance.instance;
    }

}
