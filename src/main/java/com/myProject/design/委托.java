package com.myProject.design;

import org.junit.Test;

import java.util.*;

public class 委托 {
}


class Bird {

    void fly() {
        System.out.println("我是bird 我会fly");
    }
}

interface Fly {
    void fly();
}

class FlyAbility implements Fly {
    @Override
    public void fly() {
        System.out.println("we can fly to moon");
    }
}

class SmallBird extends Bird {
    @Override
    void fly() {
        System.out.println("i cant fly....");
    }
}

class SmartBird implements Fly {
    FlyAbility b = new FlyAbility(); // 组合

    // 接口中的方法只能是public权限，这些方法在其实现类中必须显式申明为public权限，否则会报编译错误
    @Override
    public void fly() {
        // 委托
        b.fly();
    }
}

class LogList<T> implements List<T>{
    private final List<T> list;

    public LogList(List<T> list) {
        this.list = list;
    }

    @Override
    public int size() {
        System.out.println("计算list长度");
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        System.out.println("正在打印list");
        return list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        System.out.println("正在给list新增元素");
        return list.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        System.out.println("正在获取list中的元素");
        return list.get(index);
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}

class ListTest{
    public static void main(String[] args) {
//        LogList<Integer> list = new LogList<>(new ArrayList<>());
//        list.add(1);
//        list.add(1);
//        list.add(1);
//        System.out.println(list.size());
//        System.out.println(Arrays.toString(list.toArray()));
        test1();
    }

    @Test
    public static void test1() {
        Integer[] arr = {1,2,3,4,5};
        Integer[] arrObj = new Integer[]{1,2,3,4,56};
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arrObj);
        System.out.println(Arrays.toString(arrObj));
    }
}
