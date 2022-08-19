package com.myProject.threadAndLock.java.function;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author admin
 */
public class FunctionCaseTest {
    public static void main(String[] args) {
        Function<Integer, String> function1 = i -> "aaa" + i;

        Function<Integer, String> function2 = ele -> ele + "aaa";

        System.out.println(function2.apply(1));
    }

    @Test
    public void test() {
       FunctionAnnotation<Integer, String> function = ele -> System.out.println(ele + "playFootBall");
       function.eat(28);
    }

    @Test
    public void test2() {
        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test(""));
    }

    @Test
    public void test3() {
        Consumer<String> consumer = o -> System.out.println("HaHaHaHa" + o);
        Consumer<String> consumer2 = ele -> System.out.println(ele + "HAHA222");

        consumer.accept("zhangsan");
        consumer2.accept("lisi");
    }

    @Test
    public void test4() {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "小张哈哈哈";
            }
        };

        Supplier<String> supplier2 = () -> "hahahha";

        System.out.println(supplier2.get());
    }
}
