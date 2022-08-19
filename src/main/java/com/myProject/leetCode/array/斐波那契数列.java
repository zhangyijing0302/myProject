package com.myProject.leetCode.array;

import org.junit.Test;

/**
 * 0 n=0
 * 1 n=1
 * F(n-1) + F(n-2) n>1
 */
public class 斐波那契数列 {

    @Test
    public void test() {
        System.out.println(testCase1(10));
    }

    public int testCase1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return testCase1(n - 1) + testCase1(n - 2);
    }
}