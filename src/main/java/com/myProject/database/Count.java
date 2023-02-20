package com.myProject.database;

public class Count {
    /**
     * count(1) count(*) 有什么区别
     *
     * count语句返回的是select查询的结果的行数
     *
     * count(1) = select 1 from table;的行数
     *
     * count(列明)不会返回null值，但是count(1) 和 count(*)可以返回所有数据的行数
     *
     * 从结果的角度讲，count(1) 和 count(*) 返回的值是一样的
     *
     * mysql中
     * MyISAM引擎会单独记录表的行数的，仅在没有where条件的情况下，所以在MyISAM中count(*)没有条件是比较快的
     * Innodb没有这种机制，因为支持事务，事务有不同的隔离级别，对于同一张表来说，不同的事务可能在同时操作一张表，
     * 每个事务都是独立的，A事务执行插入一条数据，B事务可能不需要感知到，所以Innodb没有记录一张表有多少条数据
     * Innodb执行count(*)的过程是，
     * ·如果一张表没有索引，那做一次全表扫描
     * ·如果有主键索引，走主键索引
     * ·如果有部分字段的联合索引的话，优先走联合索引（联合索引对于B+树来说存储的字段更少，导致叶子节点的个数更少，但是也不影响总行数）
     * 无论是Innodb中在处理count(*) 和 count(1) 上没有任何区别
     *
     * count(字段)时也是一样的，字段是索引则优先走索引，没有索引就做全表扫描，且过滤空值
     *
     *
     *
     *
     *
     *
     *
     */


}
