package com.randomproject.leetCode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class 杨辉三角 {

    @Test
    public void test() {
        System.out.println(testCase(6));
    }

    public List<List<Integer>> testCase(int target) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < target; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    //外圈的1
                    list.add(1);
                } else {
                    list.add(res.get(i -1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}