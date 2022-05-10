package com.randomProject.sourceCodeAndStructure;

import com.randomProject.entity.HashSetEntity;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  1.为什么重写equals还要重写hashcode?
 *  因为必须保证重写后的equals方法认定相同的两个对象拥有相同的哈希值
 */
public class HashSetCase {

    @Test
    public void test01() {
        HashSetEntity h1 = new HashSetEntity(1, "zhangsan", 12);
        HashSetEntity h2 = new HashSetEntity(1, "lisi", 12);
        Set<HashSetEntity> set = new HashSet<>();
        boolean add1 = set.add(h1);
        System.out.println("add1:    " + add1);
        boolean add2 = set.add(h2);
        System.out.println("add2:    " + add2);
        System.out.println(set.size());
        System.out.println(Arrays.toString(set.toArray()));
    }

}