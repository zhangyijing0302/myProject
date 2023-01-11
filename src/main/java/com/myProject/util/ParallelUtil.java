package com.myProject.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParallelUtil {
    private static final Logger logger= LoggerFactory.getLogger(ParallelUtil.class);
    /**
     * 将tList中的元素逐个按照t2rFunction转换(为null则忽略该值)，使用指定的线程池。
     * @param tList t对象的列表
     * @param t2rFunction   t对象向r对象转换的逻辑
     * @param executor  线程池
     * @param <T>   入参类型
     * @param <R>   返回类型
     * @return
     */
    public static <T,R> List<R> parallelTransferIgnoreNull(List<T> tList, Function<T,R> t2rFunction, Executor executor) {
        CompletableFuture[] futureTasks = tList.stream()
                .map(t -> CompletableFuture.supplyAsync(() -> t2rFunction.apply(t), executor))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futureTasks).join();

        return Arrays.stream(futureTasks).map(future->{
            try {
                Object o = future.get();
                if (o==null){
                    return null;
                }
                return (R)o;
            } catch (InterruptedException | ExecutionException e) {
                logger.error("并行任务出错,将被忽略",e);
                return null;
            }

        }).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
