package com.myProject.company.jpjl;

/**
 * Redis 在游戏服务器开发中有什么作用？
 * @author admin
 */
public class Redis有什么用 {
    /**
     * 先说Redis有什么用？
     * Redis首先作为一个非关系型数据库，具有高效的读写数据的能力，数据可以内存存取也可以做持久化处理。
     * 然后有五大基本数据类型String,hash,list,set,zSet，三大特殊数据类型geospatial地理位置，Hyperloglog计数，Bitmaps
     * 身为数据库保存数据是基本作用，然后现在大部分公司也都是用redis做缓存
     * 除此之外redis在游戏中的应用场景可以考虑redis的一大特色功能 订阅模式
     * 通过subscribe订阅一个频道 可以实现一些类似消息同送，广告推送，活动推送，全服聊天这类型的功能，我感觉临时用户对用户的聊天也可以通过互相订阅互相发布这样的形式来实现
     * 然后看到另外一个问题中说的排行榜就可以利用redis的zSet数据类型，
     * 在set的基础上加了一个用于排序的字段，这个字段也可以根据实际情况等级，金钱做多种排序，相当于是redis自带排序功能。
     * redis在我业务开发过程中就用过一个String,再总结一下五种数据类型的特点
     * String：就是一个kv对 根据key获取balue
     * hash：一条数据就是一个kv对，比如可以保存一个学生对象
     * list：就是列表，花样比较多，跟JAVA里的list差不多，可以模拟队列，先进后出替换元素啊什么的
     * set：跟JAVA里的hashset也差不多，有无序，唯一这些特点
     * zset：有序的hashset，排序的方式是增加了一个字段score，这个字段专门用来排序的
     *
     */

}