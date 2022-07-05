package com.randomProject.java.function;

/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/6/18
 */
@FunctionalInterface
public interface FunctionAnnotation<T, R> {

    /**
     * 吃接口
     *
     * @param	food
     * @return
     * @author ZhangYijing
     * @date 2022/6/18 17:40
     */
    void eat(T food);

}