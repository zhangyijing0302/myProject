package com.myProject.temp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myProject.javaBase.entity.School;
import com.myProject.springboot.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author ZhangYijing
 * @Description
 * @Date 2022/4/25
 */
@Slf4j
public class Test01 {


    @Test
    public void test() {
        String str = "H";
        boolean b = false;
        Boolean aBoolean = Optional.ofNullable(str).map("H"::equals).orElse(false);
        System.out.println(aBoolean);
    }

    @Test
    public void test2() {
        int i = -100;
        System.out.println(~(i - 1));
    }


    @Test
    public void test3() {
        int i = 10;
        int length = 5;
        System.out.println(Math.pow(i, (length - 1)));

    }

    @Test
    public void test4() {
        BigDecimal bigDecimal = new BigDecimal("1.12345");

        System.out.println(bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP));

    }

    @Test
    public void test5() {
        String str = "abcdefghijk";

        System.out.println(str.substring(str.length() - 8));

    }

    @Test
    public void test6() {
        int n = 15;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int i = n + 1;
        System.out.println(i);
    }

    @Test
    public void test7() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);
    }

    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1,2);
    }

    @Test
    public void test8() {
        Long ll = null;
        Long lb = 25666666L;
        System.out.println(ll < lb);
    }

    @Test
    public void test9() {
        List<String> underlyingIdList = new ArrayList<>();
        underlyingIdList.add("zhangsan");
        underlyingIdList.add("lisi");
        underlyingIdList.add("wangwu");
        underlyingIdList.add("zhaoliu");
        System.out.println(underlyingIdList.contains("zhangsan"));

    }
    @Test
    public void test21() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                list.remove(integer);

            }
        }
    }
    @Test
    public void test22() {
        String[] arr = {"a", "b", "c"};
        List<String> list = Arrays.asList(arr);
        ArrayList<Object> objects = new ArrayList<>(list);
        objects.add("d");
        objects.add("e");
        objects.remove(objects.size());
        System.out.println(Arrays.toString(objects.toArray()));
    }
    @Test
    public void test23() {
        // 判断数组是否包含a
        String[] arr = {"a", "b", "c"};
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        set.add("e");
        if (set.contains("a")) {
            System.out.println("contains a");
        }


        Set<String> set2 = new HashSet<>();
        String str = null;
        System.out.println(set2.contains(str));
    }
    @Test
    public void test24() {
        // 这段代码能否执行？如果不能执行，会报什么错？如果能执行，是否有问题？
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println(list);
    }

    /**
     * 输入: I am a student 输出: student a am I
     * >
     * > #### 输入是数组 输出也是数组 不允许用 split splice reverse
     */
    @Test
    public void test25() {
        String[] strArr = new String[]{"I", "am", "a", "student"};
        String[] targetArr = new String[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            targetArr[i] = strArr[length - 1 - i];
        }
        System.out.println(Arrays.asList(targetArr));
    }
    @Test
    public void test26() {
        String[] strArr = new String[]{"I", "am", "a", "student"};
        int length = strArr.length;
        for (int i = 0; i < length / 2; i++) {
            String temp = strArr[i];
            strArr[i] = strArr[length - 1 - i];
            strArr[length - 1 - i] = temp;
        }
        System.out.println(Arrays.asList(strArr));
    }

    @Test
    public void test27() {
        List<Student> studentsWithAmount = Student.getStudentsWithAmount();
        List<BigDecimal> collect = studentsWithAmount.stream().map(Student::getAccount).collect(Collectors.toList());
        BigDecimal reduce = studentsWithAmount.stream().map(Student::getAccount).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(collect);
        System.out.println(reduce);
    }

    @Test
    public void test28() {
        Integer i = null;
        System.out.println(i == null || i == 88);
    }

    @Test
    public void test29() {
        Long l1 = Long.valueOf("188");;
        Long l2 = Long.valueOf("188");;
        System.out.println(l1 == l2);


        Long l3 = Long.valueOf ("88");
        Long l4 = Long.valueOf("88");
        System.out.println(l4 == l3);
    }
    @Test
    public void test30() {

        String fileName = "aaa.pdf";
        String[] substring = fileName.split("\\.");
        System.out.println(substring[0]);
    }

    @Test
    public void test31() {

        BigDecimal a = new BigDecimal("12.888");
        BigDecimal bigDecimal = a.setScale(4, RoundingMode.HALF_DOWN);
        System.out.println(bigDecimal.toString());
        System.out.println(bigDecimal.toPlainString());
    }
    @Test
    public void test32() {
        School school = new School();
    }

    @Test
    public void test33() {

        String str = "IC2209";
        System.out.println("IC2209888".contains(str));
        boolean equals = str.equals("!");
        Integer.valueOf(12);
    }


    @Test
    public void test34() {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next .equals("h")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    @Test
    public void test35() {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next .equals("h")) {
                iterator.remove();
                System.out.println(next);
                continue;
            }
            if (next.equals("i")) {
                System.out.println(next);
            }
        }
        System.out.println(list);
    }


    @Test
    public void test36() {

       BigDecimal big1 = new BigDecimal("12.888");
       BigDecimal big2 = new BigDecimal("0");
        BigDecimal[] bigDecimals = big1.divideAndRemainder(BigDecimal.ONE);
        System.out.println(bigDecimals[0]);
        System.out.println(bigDecimals[1].compareTo(BigDecimal.ZERO));
        System.out.println(big2.divideAndRemainder(BigDecimal.ONE)[0]);
        BigDecimal bigDecimal = big2.divideAndRemainder(BigDecimal.ONE)[1];
        System.out.println(bigDecimal.compareTo(BigDecimal.ZERO));

    }

    @Test
    public void test37() {

        for (int i = 0; i < 10; i++) {
            if (i > 4) {
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    continue;
                }
                System.out.println("第二层" + j);
            }

            System.out.println("第一层" + i);

        }

    }

    @Test
    public void test38() {

        ArrayList<Student> objects = new ArrayList<>();
        Map<BigDecimal, List<Student>> collect = objects.stream().collect(Collectors.groupingBy(Student::getAccount));

        Map<String, String> map = new HashMap<>();
        String s = map.getOrDefault("", new String());
        System.out.println(s);

    }

    @Test
    public void test39() {

        BigDecimal bigDecimal = new BigDecimal("12");
        System.out.println(bigDecimal.negate().toPlainString());

    }

    @Test
    public void test41() {
       int i = 88;
        System.out.println(i<<1);
    }
    @Test
    public void test40() {
        Integer i1 = 1024;
        Integer i2 = 21;
        System.out.println(i1 / i2);
    }

    @Test
    public void test42() throws JsonProcessingException {
        Student student = new Student();
        student.setName("dashabi");
        testObject(student);
    }



    private void testObject(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(mapper.writeValueAsString(object), Map.class);
        Object name = map.get("seax");
        System.out.println(name);
    }

}