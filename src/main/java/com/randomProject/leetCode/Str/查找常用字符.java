package com.randomProject.leetCode.Str;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次
 */
public class 查找常用字符 {

    @Test
    public void test() {
        String[] str = new String[]{"cooli","locki","cooki"};
//        System.out.println(commonChars(str));
        System.out.println(testCase(str));
    }

    public List<String> commonChars(String[] A) {
        //仅有小写字母，可以利用ascll码
        List<String> list = new ArrayList<>();
        int[] num = new int[26];
        for(char ch : A[0].toCharArray()){
            num[ch - 'a'] ++;
        }

        for(int i = 1; i < A.length; i++){
            int[] tmp = new int[26];
            for(char ch : A[i].toCharArray()){
                tmp[ch - 'a'] ++;
            }

            for(int j = 0; j < 26; j++) {
                //找交集
                num[j] = Math.min(num[j], tmp[j]);
            }
        }

        for(int i = 0; i < num.length; i++){
            if(num[i] > 0){
                for(int j = 0; j < num[i]; j++) {
                    list.add(((char)('a' + i ) + ""));
                }
            }
        }

        return list;
    }

    public List<String> testCase(String[] array) {
        List<String> result = new ArrayList<>();
        char[] chars = array[0].toCharArray();
        int[] num = new int[26];
        for (int i = 0; i < chars.length; i++) {
            num[chars[i] - 'a']++;
        }

        for (int i = 1; i < array.length; i++) {
            char[] chars1 = array[i].toCharArray();
            int[] temp = new int[26];
            for (char c : chars1) {
                temp[c - 'a']++;
            }

            for (int j = 0; j < num.length; j++) {
                num[j] = Math.min(num[j], temp[j]);
            }
        }

        System.out.println(Arrays.toString(num));
        return result;
    }

}