package com.myProject.juc.readAndWriteLock;

import java.util.LinkedList;
import java.util.List;

public class TestCase {
    public static void test(UnLockEntity unLockEntity) {
        long start = System.currentTimeMillis();
        List<Thread> threads = new LinkedList<>();
        for (int i=0;i<10000;i++){
            //读线程
            threads.add(new Thread(() -> {
                long value = unLockEntity.get();
                if (value > UnLockEntity.MAX){
                    CommonMethod.log("读到错误的数据了");
                    System.exit(-1);
                }
                CommonMethod.log("get " + value);
            }, "thread-get-" + i));
            //写线程
            threads.add(new Thread(unLockEntity::add,"thread-add-" + i));
        }

        CommonMethod.start(threads);
        CommonMethod.join(threads);
        CommonMethod.log(""+ unLockEntity.get());
        CommonMethod.log("耗时："+(System.currentTimeMillis()-start));
    }
}
