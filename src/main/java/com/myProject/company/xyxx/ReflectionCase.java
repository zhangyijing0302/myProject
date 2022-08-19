package com.myProject.company.xyxx;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * <p>功能: 使用反射实现如下功能，并运行出正确的结果
 * <pre>
     List<Integer> myList = new ArrayList<Integer>(10);
     myList.add(1);
     myList.add(3);
     myList.add(5);
     myList.add(7);
     myList.add(9);
     myList.add(8);
     myList.add(6);
     myList.add(4);
     myList.add(2);
     myList.add(10);
     Collections.sort(myList);
     System.out.println(myList);
     </pre>
 */
public class ReflectionCase {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>(10);
        try {
            // 声明
            Class arrayListClass = myList.getClass();
            ArrayList arrayList = (ArrayList)arrayListClass.newInstance();
            Method addMethod = arrayListClass.getDeclaredMethod("add", Object.class);
            addMethod.invoke(arrayList, 1);
            addMethod.invoke(arrayList, 3);
            addMethod.invoke(arrayList, 5);
            addMethod.invoke(arrayList, 7);
            addMethod.invoke(arrayList, 9);
            addMethod.invoke(arrayList, 8);
            addMethod.invoke(arrayList, 6);
            addMethod.invoke(arrayList, 4);
            addMethod.invoke(arrayList, 2);
            addMethod.invoke(arrayList, 10);
            System.out.println(arrayList);
            // 排序
            Class<Collections> collectionsClass = Collections.class;
            Method sortMethod = collectionsClass.getDeclaredMethod("sort", List.class);
            sortMethod.setAccessible(true);
            sortMethod.invoke(arrayList, (Object) arrayList);
            System.out.println(arrayList);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
