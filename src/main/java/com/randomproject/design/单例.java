package com.randomproject.design;

/**
 * 单例
 */
public final class 单例 {

    private 单例(){}

    private static 单例 instanceObject = null;

    public static 单例 getInstance() {
        if (instanceObject == null) {
            synchronized(单例.class) {
                if (instanceObject == null) {
                    instanceObject = new 单例();
                }
            }
        }
        return instanceObject;
    }
}