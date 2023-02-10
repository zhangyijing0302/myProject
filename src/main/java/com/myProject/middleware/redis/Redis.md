# Redis

## 启动

```bash
#目录
 /usr/local/bin
# 指定配置文件启动
./redis-server ./redisconfig/redis.conf 
# redis客户端指定端口连接
redis-cli -p 6379
```

## NoSQL

大数据时代、一般的数据库无法分析处理了，为什么要用nosql？

```
1. 单机mysql时代，更多使用html静态网页，服务器没有太大压力，单个数据库完全足够
	瓶颈：
	· 数据量太大的时候，一个机器放不下了
	· 数据库索引建立，内存不够用
	· 访问量（读写混合），一个服务器承受不了
2. Memcached(缓存) + MYSQL + 垂直拆分
	网站80%的情况都是在读，每次都与数据库交互的话会非常麻烦，为了减轻数据库的压力，所以引入缓存的概念，保证用户访问效率。
	· 优化数据库结构和索引--》文件缓存（IO）--》Memcached
3. 分库分表 + 水平拆分 + 数据库集群
4.  MYSQL等关系型数据库不够用了，数据量多、变化也快，用户自己产生的数据，
	存储数据量大的文件、图片，效率就低了，所以需要一种专门处理这些数据的方法来减轻mysql的压力，nosql就可以很好的处理这些问题
```

```
Nosql
泛指非关系型数据库，随着web互相网更新，视频，图片，地理位置，社交网络，以及一些超大规模的高并发的社区，暴漏出来很多难以克服的问题，Nosql在当今大数据环境下发展十分迅速，redis是发展最快的
```

### nosql特点

- 解耦，方便拓展（数据之间没有关系）

- 大数据量高性能（redis每秒读取11万次写8万次，nosql缓存细粒度级，性能较高）

- 数据类型是多样的（不需要事前设计数据库，随去随用，如果数据量大就无法设计了）

- 传统的RDBMS和NoSQL比较

  | RDBMS                                                | NoSQL                                    |
  | ---------------------------------------------------- | ---------------------------------------- |
  | 结构化组织结构化组织                                 | 不仅仅是数据                             |
  | SQL                                                  | 没有固定的查询语言                       |
  | 数据和关系都存在固定的表中数据和关系都存在固定的表中 | 键值对存储，列存储，文档存储，图形数据库 |
  | 严格的一致性                                         | 最终一致性                               |
  | 基础的事务                                           | CAP定理和BASE理论（异地多活）            |
  | 。。。。                                             | 高性能、高可用、高可扩展                 |

- 了解大数据时代的3V和3高

  | 大数据时代的3V | 大数据时代的3高                          |
  | -------------- | ---------------------------------------- |
  | 海量Volume     | 高并发                                   |
  | 多样Variety    | 高可扩展(随时水平拆分，机器不够了加机器) |
  | 实时Velocity   | 高性能(保证用户体验和高性能)             |

### nosql的四大分类

1. KV键值对：
2. 文档型数据库(bson):
   1. ​	MongoDB：
      - ​	MongoDB是一个基于分布式文件存储的数据库，C++编写，主要用来存储大量的文档
      - ​    MongoDB是一个介于关系型数据库和非关系型数据库中间的产品，MongoDB是非关系型数据库中功能最丰富，最像关系型数据库的。
   2. ​    **ConthDB**
3. 列存储数据库
   - HBase
   - 分布式文件系统
4. 图关系数据库
   - 它不是存图片的，他是用来存关系的，比如朋友圈社交网络，广告推荐
   - Neo4j

| 分类              | Examples举例                                       | 典型应用场景                                                 | 数据模型                                        | 优点                                                         | 缺点                                                         |
| ----------------- | -------------------------------------------------- | ------------------------------------------------------------ | ----------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 键值（key-value） | Tokyo Cabinet/Tyrant, Redis, Voldemort, Oracle BDB | 内容缓存，主要用于处理大量数据的高访问负载，也用于一些日志系统等等。 | Key 指向 Value 的键值对，通常用hash table来实现 | 查找速度快                                                   | 数据无结构化，通常只被当作字符串或者二进制数据               |
| 列存储数据库      | Cassandra, HBase, Riak                             | 分布式的文件系统                                             | 以列簇式存储，将同一列数据存在一起              | 查找速度快，可扩展性强，更容易进行分布式扩展                 | 功能相对局限                                                 |
| 文档型数据库      | CouchDB, MongoDbx'z                                | Web应用（与Key-Value类似，Value是结构化的，不同的是数据库能够了解Value的内容） | Key-Value对应的键值对，Value为结构化数据        | 数据结构要求不严格，表结构可变，不需要像关系型数据库一样需要预先定义表结构 | 查询性能不高，而且缺乏统一的查询语法。                       |
| 图形(Graph)数据库 | Neo4J, InfoGrid, Infinite Graph                    | 社交网络，推荐系统等。专注于构建关系图谱                     | 图结构                                          | 利用图结构相关算法。比如最短路径寻址，N度关系查找等          | 很多时候需要对整个图做计算才能得出需要的信息，而且这种结构不太好做分布式的集群方案。 |

## Redis

Redis，远程字典服务

> Ridis能干什么？

1. 内存存储、持久化、内存中是关机即消失，所以做持久化很重要。
2. 效率高，用于高速缓存。
3. 发布订阅系统
4. 地图信息分析
5. 计时器、计数器（浏览量）

> 特性

1. 多样化的数据类型
2. 持久化
3. 集群
4. 事务

> 学习中需要用到的东西

1. Ridis官网:https://redis.io/
2. Redis中文网:http://www.redis.cn/

## window环境安装

。。。

## Linux环境安装

1. 下载安装包上传

2. 解压安装包 tar -zxvf 

3. 进入解压后的文件，可以看到redis的配置文件

4. 基本的环境安装

   ```shell
   yum install -y gcc-c++
   
   make
   ```

5. redis的默认安装路径 /usr/local/bin

6. 将redis配置文档复制到/usr/local/bin目录下

7. redis默认不是后台启动的，可修改配置文件

![image-20210912160700659](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20210912160700659.png)

​	8.启动redis服务

![image-20211028210734393](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20211028210734393.png)

```shell
#目录
 /usr/local/bin
# 指定配置文件启动
./redis-server ./redisconfig/redis.conf 
# redis客户端指定端口连接
redis-cli -p 6379
```

​    9.查看redis进程

```shell
ps -ef|grep redis
```

​	10.关闭redis

```shell
连接redis后shutdown
```

## 测试redis性能

```shell
#压力测试 本次100个并发 每个有10万个请求
redis-benchmark -h localhost -p 6379 -c 100 -n 100000
```

![image-20211013201925684](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20211013201925684.png)

## redis基础知识

- redis默认有16个数据库

  ```
  cd /usr/local/bin/redisconfig
  vi redis.config
  通过/“字符串”，在vi下查找，按n查找下一个
  默认在第0个，可以通过select切换数据库
  ```

  ![image-20211013202721748](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20211013202721748.png)

```shell
127.0.0.1:6379> select 3  #切换数据库
OK
127.0.0.1:6379[3]> dbsize 	#查看数据库大小
(integer) 0
127.0.0.1:6379[3]> keys *	#查看所有的key
1) "name"
127.0.0.1:6379[3]> flushdb	#清空当前数据库
127.0.0.1:6379[3]> flushall	#清空全部数据库
127.0.0.1:6379> exists name #判断某一个键是否存在
(integer) 1
127.0.0.1:6379> move name 1	#移动键到1号库
(integer) 1
127.0.0.1:6379[1]> expire name 10 # 设置键过期倒计时
(integer) 1
127.0.0.1:6379[1]> ttl name	# 查看当前key的剩余时间
(integer) 6
127.0.0.1:6379> type name	#查看当前key的类型
string


```

- 为什么redis的默认端口号是6379？

```
因为女人
```

- 为什么Redis是单线程的？

```
redis是很尽快的，基于内存操作的，cpu不是redis的性能瓶颈，Redis的瓶颈是机器的内存和网络带宽，单线程可以实现所以就用单线程。
```

- 为什么单线程还这么快？

```
redis是C语言写的，官方提供的数据是100000+的QPS，足以说明redis不比memecache差
1，误区一，高性能的服务器一定是多线程的
2，误区二，多线程（CPU上下文切换）的一定比单线程效率高

redis是将所有的数据存放在内存中的，使用单线程是操作效率最高的，多线程的话CPU上下文切换也是一个耗时点，对于内存系统来说，没有上下文的切换的效率是最高的。多次读写都是在一个CPU上执行的。
```

## Redis五大基本数据类型

![image-20211018202948193](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20211018202948193.png)

```
Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，
它可以用作数据库、缓存和消息中间件。 
它支持多种类型的数据结构，如 字符串（strings）， 散列（hashes）， 列表（lists）， 集合（sets）， 有序集合（sorted sets） 与范围查询， bitmaps， hyperloglogs 和 地理空间（geospatial） 索引半径查询。 
Redis 内置了 复制（replication），LUA脚本（Lua scripting）， LRU驱动事件（LRU eviction），事务（transactions） 和不同级别的 磁盘持久化（persistence）， 并通过 Redis哨兵（Sentinel）和自动 分区（Cluster）提供高可用性（high availability）。 
```

### ·Redis-Key

### 1.字符串（strings）

90%的java程序员使用redis只使用一个string类型

```shell
127.0.0.1:6379> append val ",lisi"	#追加字符串，如果当前字符串不存在，就相当于set key value
(integer) 10
127.0.0.1:6379> get val
"hello,lisi"
127.0.0.1:6379> strlen val	#获取字符串长度
(integer) 10
127.0.0.1:6379> set views 0	#设置初始值为0
OK
127.0.0.1:6379> incr views	#自动实现+1操作，
(integer) 1
127.0.0.1:6379> decr views	#自动实现-1操作，
(integer) 0
127.0.0.1:6379> incrby views 10	#自动实现增加指定步长的操作，
(integer) 17
127.0.0.1:6379> decrby views 10	#自动实现减少指定步长的操作，
(integer) 7
-------------------------------------------------------------------
# range 截取字符串
127.0.0.1:6379> set key1 zhangyijing
OK
127.0.0.1:6379> get key1
"zhangyijing"
127.0.0.1:6379> getrange key1 0 3 # 获取第0位到第三位
"zhan"
127.0.0.1:6379> getrange key1 0 -1 #获取第0位到最后一位
"zhangyijing"
# setrange替换字符串
127.0.0.1:6379> SETRANGE key1 1 xxx # 从第1位开始替换
(integer) 11
127.0.0.1:6379> get key1
"zxxxgyijing"
-------------------------------------------------------------------
# setex （set with expire）  设置过期时间
# setnx （set if not exist）当前不存在 不存在的话设置,分布式锁中常用
127.0.0.1:6379> setex key3 30 hello # 设置一个key3 值位hello 30秒后过期
OK
127.0.0.1:6379> ttl key3
(integer) 25
127.0.0.1:6379> setnx key1 lisi # 当前不存在key1的话设置值，存在的话设置失败
(integer) 0
127.0.0.1:6379> get key1
"zxxxgyijing"
-------------------------------------------------------------------
# mset 批量set值
127.0.0.1:6379> mset k1 v1 k2 v2 k3 v3
OK
127.0.0.1:6379> keys *
1) "k2"
2) "k1"
3) "k3"
# mget	批量获取值
127.0.0.1:6379> mget k1 k2 k3
1) "v1"
2) "v2"
3) "v3"
# 使用msetnx，可以发现即使不存在k4也会设置失败，是一个原子性的操作
127.0.0.1:6379> msetnx k1 v1 k4 v4
(integer) 0
127.0.0.1:6379> get k4
(nil)
-------------------------------------------------------------------
# 对象
set user zhangsan {name:zhangsan, age:18, hobby:basketball}
127.0.0.1:6379> mset user:1:name zhangsan user:1:age 2
OK
127.0.0.1:6379> mget user:1:name user:1:age
1) "zhangsan"
2) "2"
-------------------------------------------------------------------
# getset #先获取再set
127.0.0.1:6379> getset kk redis #如果之前不存在，返回null，但是给kk设置了值
(nil)
127.0.0.1:6379> getset kk mongdb #如果之前存在，返回之前的值，但设置了新的值
"redis"
127.0.0.1:6379> get kk
"mongdb"
-------------------------------------------------------------------
String类型的使用场景：
1、字符串
2、数字
3、浏览量、（统计数量）、
4、对象缓存存储
```

### 2.散列（hashes）

```bash
# Map集合 Key-Value
# hset key field value
# hget key field
127.0.0.1:6379> hset myhash name zhangsan
(integer) 1
127.0.0.1:6379> hget myhash name
"zhangsan"
# hmset key field value [...] 同时set多个值
# hmget key field [...] 同时get多个值
127.0.0.1:6379> hmset hash name zhangsan age 18
OK
127.0.0.1:6379> hmget hash name age
1) "zhangsan"
2) "18"
# hgetall key 获取所有的hash集合的key和value
127.0.0.1:6379> hgetall hash
1) "name"
2) "zhangsan"
3) "age"
4) "18"
-------------------------------------------------------------------
# hdel key field[fields...] 删除hash指定的hashkey字段，对应的value值也一起消失
127.0.0.1:6379> hdel hash name
(integer) 1
127.0.0.1:6379> hgetall hash
1) "age"
2) "18"
-------------------------------------------------------------------
# hlen key 获取指定hash集合的长度
127.0.0.1:6379> hgetall hash
1) "age"
2) "18"
3) "name"
4) "lsii"
127.0.0.1:6379> hlen hash
(integer) 2
-------------------------------------------------------------------
# hexists key field 判断某一个hash的key是否存在
127.0.0.1:6379> HEXISTS hash hobby
(integer) 0
127.0.0.1:6379> HEXISTS hash name
(integer) 1zijian
-------------------------------------------------------------------
# hkeys key 获取hash所有的key
# hvals key 获取hash所有的value
127.0.0.1:6379> hkeys hash
1) "age"
2) "name"
127.0.0.1:6379> hvals hash
1) "18"
2) "lsii"
-------------------------------------------------------------------
# hincrby key field increment 指定hashKey的value值自增increment
127.0.0.1:6379> hvals hash
1) "18"
2) "lsii"
127.0.0.1:6379> HINCRBY hash age 1
(integer) 19
# hsetnx key field value 如果不存在则给指定key设置一个value值，如果存在则设置失败
127.0.0.1:6379> HSETNX hash wife 1
(integer) 1
127.0.0.1:6379> HSETNX hash wife 2
(integer) 0
# hash可以很好的保存一个对象，对于需要变动的信息也很方便
```

### 3.列表（lists）

```bash
# 也是一种基本的数据类型 redis中可以用list模拟 栈、堆、阻塞队列
-------------------------------------------------------------------
# lpush lrange 往头部插入、先存进去的在尾部，像栈
127.0.0.1:6379> lpush list one two three
(integer) 3
127.0.0.1:6379> lrange list 0 -1
1) "three"
2) "two"
3) "one"
127.0.0.1:6379> RPUSH list r1 r2 r3 # rpush代表从尾部开始插入
(integer) 6
127.0.0.1:6379> lrange list 0 -1
1) "three"
2) "two"
3) "one"
4) "r1"
5) "r2"
6) "r3"
-------------------------------------------------------------------
# LPOP 从左边开始移除（弹出）一个元素
# RPOP 从右边开始移除（弹出）一个元素
127.0.0.1:6379> Lpop list
"h5"
127.0.0.1:6379> Rpop list
"h1"
127.0.0.1:6379> lrange list 0 -1
1) "three"
2) "two"
3) "one"
4) "r1"
5) "r2"
6) "r3"
-------------------------------------------------------------------
# lindex 通过下标获取值
127.0.0.1:6379> lindex list 0
"three"
127.0.0.1:6379> lindex list 9
(nil)
-------------------------------------------------------------------
# llen 返回列表的长度
127.0.0.1:6379> llen list
(integer) 6
-------------------------------------------------------------------
# lrem key count value 删除（弹出）指定的值
127.0.0.1:6379> lrange list 0 -1
1) "three"
2) "three"
3) "two"
4) "r1"
5) "r2"
6) "r3"
127.0.0.1:6379> lrem list 2 three # 移除list中2个value为three的元素
(integer) 2
127.0.0.1:6379> lrange list 0 -1
1) "two"
2) "r1"
3) "r2"
4) "r3"
-------------------------------------------------------------------
# trim key start stop 通过下标截取指定元素，list本身发生变化
127.0.0.1:6379> lrange list 0 -1
1) "r1"
2) "r2"
3) "r3"
127.0.0.1:6379> ltrim list 1 2
OK
127.0.0.1:6379> lrange list 0 -1
1) "r2"
2) "r3"
-------------------------------------------------------------------
# rpoplpush source destination 从一个list删除并推送到另一个list
127.0.0.1:6379> rpoplpush list mylist # 返回移动的元素
"r3"
127.0.0.1:6379> lrange list 0 -1	# 原来的list
1) "r1"
2) "r2"
127.0.0.1:6379> lrange mylist 0 -1	# 目标list
1) "r3"
-------------------------------------------------------------------
# lset key index value 给指定下标list替换值，如果list不存在则报错，如果要替换的下标位置不存在，也会报错
127.0.0.1:6379> lset kk 0 r1 # list不存在，报错
(error) ERR no such key
127.0.0.1:6379> lpush kk r1
(integer) 1
127.0.0.1:6379> lset kk 1 r2 # 下标不存在，报错
(error) ERR index out of range
127.0.0.1:6379> lset kk 0 r2 # 把kk中第0个元素的值替换成r2
OK
127.0.0.1:6379> lrange kk 0 -1
1) "r2"
-------------------------------------------------------------------
#linsert key before|after pivot value 将具体的值插入到列表中指定元素的前面或者后面，如果有重复元素，以左边的为准
127.0.0.1:6379> lrange kk 0 -1
1) "r2"
127.0.0.1:6379> linsert kk AFTER r2 rr2
(integer) 2
127.0.0.1:6379> lrange kk 0 -1
1) "r2"
2) "rr2"
127.0.0.1:6379> linsert kk before rr2 r12
(integer) 3
127.0.0.1:6379> lrange kk 0 -1
1) "r2"
2) "r12"
3) "rr2"
```

### 4.集合（sets）

```bash
# set 无序不重复集合
# sadd myset hello 给set集合添加元素、set中不能有重复元素
127.0.0.1:6379> sadd set hello
(integer) 1
127.0.0.1:6379> sadd set hello1
(integer) 1
127.0.0.1:6379> sadd set hello2
(integer) 1
127.0.0.1:6379> SMEMBERS set # 查看set集合元素
1) "hello"
2) "hello2"
3) "hello1"
-------------------------------------------------------------------
# sismember 判断元素是否存在
127.0.0.1:6379> sismember set hello
(integer) 1
127.0.0.1:6379> sismember set haha
(integer) 0
-------------------------------------------------------------------
# scard 获取set集合中的元素个数
127.0.0.1:6379> scard set
(integer) 
-------------------------------------------------------------------
# srem key value 移除set集合中指定元素
127.0.0.1:6379> SMEMBERS set
1) "hello"
2) "hello2"
3) "hello1"
127.0.0.1:6379> srem set hello hello44
(integer) 1
127.0.0.1:6379> SMEMBERS set
1) "hello2"
2) "hello1"
-------------------------------------------------------------------
# srandmember key count 随机在set集合中抽取指定个数的元素
127.0.0.1:6379> srandmember set 
"hello2"
127.0.0.1:6379> srandmember set 2
1) "hello"
2) "hello2"
-------------------------------------------------------------------
# spop key [count] 随机弹出集合中的count个元素
127.0.0.1:6379> SMEMBERS set
1) "hello5"
2) "hello"
3) "hello3"
4) "hello2"
5) "hello4"
6) "hello1"
127.0.0.1:6379> spop set 2
1) "hello2"
2) "hello"
127.0.0.1:6379> SMEMBERS set
1) "hello5"
2) "hello3"
3) "hello4"
4) "hello1
-------------------------------------------------------------------
# smove source destination member将一个指定的值移动到另外一个set集合中
127.0.0.1:6379> smove set set3 hello3
(integer) 1
127.0.0.1:6379> SMEMBERS set3
1) "hello3"
-------------------------------------------------------------------
# 微博 QQ 可以看到一个 共同关注  （交集、差集、并集） 
# sdiff key [key...]  
127.0.0.1:6379> SMEMBERS set1
1) "c"
2) "b"
3) "a"
127.0.0.1:6379> SMEMBERS set2
1) "c"
2) "d"
3) "e"
127.0.0.1:6379> SDIFF set1 set2 # set1跟set2的差集
1) "a"
2) "b"
# sinter key1 [key...] # 两个集合的交集
127.0.0.1:6379> sinter set1 set2
1) "c"
# sunion key1 [key...] # 两个集合的并集
127.0.0.1:6379> sunion set1 set2
1) "c"
2) "d"
3) "a"
4) "b"
5) "e"
```

### 5.有序集合（sorted sets、Zset）

```bash
# 在set的基础上，增加了一个值，set k1 v1 || zset k1 score1 v1
# zadd key [NX|XX] [CH] [INCR] score member [score member ...] 
127.0.0.1:6379> zadd zset 1 one # 在增加元素的时候多了一个分组
(integer) 1
127.0.0.1:6379> zadd zset 2 two 3 three # 添加多个
(integer) 2
127.0.0.1:6379> zrange zset 0 -1
1) "one"
2) "two"
3) "three"
# zrangebyscore key min max [withscores]排序功能
127.0.0.1:6379> zadd salary 2500 zhangsan # 添加四个用户，和他们的工资
(integer) 1
127.0.0.1:6379> zadd salary 3000 lisi 5000 wangwu
(integer) 2
127.0.0.1:6379> zadd salary 500 zhaoliu
(integer) 1
127.0.0.1:6379> ZRANGEBYSCORE salary -inf +inf # inf无穷大
1) "zhaoliu"
2) "zhangsan"
3) "lisi"
4) "wangwu"
127.0.0.1:6379> ZRANGEBYSCORE salary -inf +inf withscores # 排序的时候带上score
1) "zhaoliu"
2) "500"
3) "zhangsan"
4) "2500"
5) "lisi"
6) "3000"
7) "wangwu"
8) "5000"
127.0.0.1:6379> ZRANGEBYSCORE salary -inf 2500 withscores # 显示工资在负无穷大到2500的范围
1) "zhaoliu"
2) "500"
3) "zhangsan"
4) "2500"
-------------------------------------------------------------------
# zrevrange key start stop [withscores] 从大到小排序(反转的排序)
127.0.0.1:6379> zrevrange salary 0 2 withscores
1) "wangwu"
2) "5000"
3) "zhangsan"
4) "2500"
5) "zhaoliu"
6) "500"
127.0.0.1:6379> zrange salary 0 -1
1) "zhaoliu"
2) "zhangsan"
3) "wangwu"
-------------------------------------------------------------------
# zrem key member [member....] 移除元素
127.0.0.1:6379> zrange salary 0 -1
1) "zhaoliu"
2) "zhangsan"
3) "lisi"
4) "wangwu"
127.0.0.1:6379> zrem salary lisi # 移除lisi
(integer) 1
127.0.0.1:6379> zrange salary 0 -1
1) "zhaoliu"
2) "zhangsan"
3) "wangwu"
-------------------------------------------------------------------
# zcard key 获取有序集合中的个数
127.0.0.1:6379> zcard salary
(integer) 3
-------------------------------------------------------------------
# zcount key min max 获取指定范围内的成员数量
127.0.0.1:6379> zrange set 0 -1 withscores
1) "hello"
2) "1"
3) "world"
4) "2"
5) "and"
6) "3"
7) "zhangsan"
8) "4"
127.0.0.1:6379> zcount set -inf +inf
(integer) 4
127.0.0.1:6379> zcount set 1 3
(integer) 3
-------------------------------------------------------------------
#zset相比于set，多了一个可以排序的功能，可以做成绩排序，工资排序，设置一些权重值
#排行榜应用实现，取top10
```

## Redis三种特殊数据类型

### 1.geospatial 地理位置

Redis的GEO在Redis3.2版本就引入了，可以用于朋友圈的定位、打车，附近的人,GEO可以推算地理位置信息，两地之间的距离，方圆几公里内的人

查询一些地理位置信息：http://www.jsons.cn/lngcode/

```bash
# GEOADD key longitude（经度） latitude（维度） member[...]添加一些城市的位置
# 一般会下载城市信息一键导入
# 有效精度-180到180度
# 有效维度-85.05112878到85.05112878度 
# 否则会返回一个错误
127.0.0.1:6379> geoadd china:city 106.50 29.53 chongqing 114.05 22.54 shenzhen 121.47 31.23 shanghai 116.40 39.90 beijing
(integer) 4
-------------------------------------------------------------------
# GEODIST key member1 member2 [unit]返回两个member之间的距离，如果有一个不存在，则返回空，unit单位可选值 m米，km千米, mi英里，ft英尺
127.0.0.1:6379> geodist china:city beijing shanghai m
"1067378.7564"
127.0.0.1:6379> geodist china:city beijing shanghai km
"1067.3788"
127.0.0.1:6379> geodist china:city beijing shanghai ft
"3501898.8071"
127.0.0.1:6379> geodist china:city beijing shanghai mi
"663.2401"
127.0.0.1:6379> geodist china:city beijing shanghai ml
(error) ERR unsupported unit provided. please #use m, km, ft, mi
-------------------------------------------------------------------
# GEOHASH key member [member....]返回一个或多个位置元素时的GEOHASH表示，将返回一个11位的hash字符串，将二维的经纬度转换为一维的字符串，两个字符串越像距离越接近
127.0.0.1:6379> geohash china:city chongqing
1) "wm5xzrybty0"
-------------------------------------------------------------------
# GEOPOS key member [members...]  获取指定城市的经纬度
127.0.0.1:6379> geopos china:city beijing
1) 1) "116.39999896287918091"
   2) "39.90000009167092543"
-------------------------------------------------------------------
# GEORADIUS key longitude latitude radius m|km|ft|mi [withcoord] [withdist] [Count count] [ASC|DESC] 以给定的经纬度为中心，找出某一半径内的元素
127.0.0.1:6379> GEORADIUS china:city 110 30 1000 km 
1) "chongqing"
2) "shenzhen"
-------------------------------------------------------------------
# GEORADIUSBYMEMBER
127.0.0.1:6379> GEORADIUSBYMEMBER china:city chongqing 1000 km # 中心点变成指定位置
1) "chongqing"
-------------------------------------------------------------------
# GEO底层的实现原理是由zset实现的，可以用zset来操作geo，可以通过zset查看，删除geo元素
127.0.0.1:6379> geohash china:city chongqing
1) "wm5xzrybty0"
127.0.0.1:6379> ZREM china:city chongqing
(integer) 1
127.0.0.1:6379> zrange china:city 0 -1
1) "shenzhen"
2) "shanghai"
3) "beijing"
```

### 2.Hyperloglog基数计数

```bash
基数：不重复的元素个数
A （1，3，5，7，9）
B （1，2，3，4，5）
基数=3，可以接受误差
```

```bash
Hyperloglog简介：
Redis2.8.9版本更新了Hyperloglog数据结构
专业用于计数的数据结构
网页的UV（一个人访问一个网站多次，但是还是算作一个人）
传统方式：使用set保存用户的id，有重度的id的话就覆盖掉，就可以统计set中的元素数量作为标准来判断。如果保存大量的用户id就会比较麻烦，我们的目的是为了计数，而不是存储用户的id。
优点：占用的内存是固定的，2^64个不同元素的计数，只需要12KB的内存，如果从内存角度来比较的话，Hyperloglog就是首选。
官方统计0.81%的错误率，可以忽略不计
# pfadd key element [elements....]
127.0.0.1:6379> PFADD mypf a b c d e f g h a a a  # 创建第一组元素
(integer) 1
127.0.0.1:6379> PFCOUNT mypf
(integer) 8
127.0.0.1:6379> pfadd mypf2 i j k l m n o # 创建第二组元素
(integer) 1
127.0.0.1:6379> pfcount mypf2
(integer) 7
# pfmerge destkey sourcekey [sourcekey ...] 合并第一组和第二组
127.0.0.1:6379> PFMERGE mypf3 mypf mypf2
OK
127.0.0.1:6379> pfcount mypf3
(integer) 15
-------------------------------------------------------------------
如果是大数据量允许容错的情况下，hyperloglog绝对是不二之选
如果不允许容错，那么可以使用set或者其他数据结构
```

### 3.Bitmaps

```bash
位存储：
比如统计疫情感染人数： 0 0 0 0 0 1 1 0 0 0 
比如统计用户信息：活跃|不活跃, 登录|未登录， 
诸如次类只有两种状态的，都可以使用Bigmaps
# Bitmap 位图，数据结构，都是操作二进制位来进行记录，就只有0和1的状态
# 只需要一个bit来存储，1字节就有8bit
-------------------------------------------------------------------
# setbit key offset value 
# 记录周一到周日的打卡， 周二周三没有打卡
127.0.0.1:6379> setbit xingqi 1 1
(integer) 0
127.0.0.1:6379> setbit xingqi 2 0
(integer) 0
127.0.0.1:6379> setbit xingqi 3 0
(integer) 0
127.0.0.1:6379> setbit xingqi 4 1
(integer) 0
127.0.0.1:6379> setbit xingqi 5 1
(integer) 0
127.0.0.1:6379> setbit xingqi 6 1
(integer) 0
127.0.0.1:6379> setbit xingqi 7 1
(integer) 0
# getbit key offset查看星期二和星期四有没有打卡
127.0.0.1:6379> GETBIT xingqi 2
(integer) 0
127.0.0.1:6379> GETBIT xingqi 4
(integer) 1
# bitcount key [start end]统计打卡的天数 统计字符串被设置为1的bit数
127.0.0.1:6379> BITCOUNT xingqi 
(integer) 6
```

## Redis中的事务

```bash
事务具有ACID(原子性，隔离性，一致性，持久性)原则，要么同时成功，要么同时失败
Redis的单条命令是保证原子性的
Redis的事务是不保证原子性的
Redis一个事务中的所有命令都会被序列化，在事务的执行过程中，会按照顺序执行
一次行、顺序性、排他性，执行所有的命令
```

redis中没有隔离级别的概念

所有的命令在事务中，并没有直接执行，只有发起执行命令才会开始执行。

Redis的事务分为三个阶段：

- 开启事务（multi）
- 命令入队（）
- 执行事务（exec）
- 放弃事务 （discard）

```bash
# exec 正常执行事务
127.0.0.1:6379> MULTI	# 开启事务
OK
127.0.0.1:6379> set k1 v1
QUEUED
127.0.0.1:6379> set k2 v2
QUEUED
127.0.0.1:6379> get k2
QUEUED
127.0.0.1:6379> exec	# 执行事务
1) OK
2) OK
3) "v2"
# DISCARD 放弃事务,事务队列中的命令都不会被执行
127.0.0.1:6379> MULTI
OK
127.0.0.1:6379> set kk1 v1
QUEUED
127.0.0.1:6379> set kk2 v2
QUEUED
127.0.0.1:6379> set kk4 v4
QUEUED
127.0.0.1:6379> DISCARD
OK
127.0.0.1:6379> get kk4
(nil)
# 如果执行事务过程中有一条命令发生运行时异常了，其他命令是可以正常执行的。
```

## Redis中实现乐观锁：watch

悲观锁：

- ​	什么时候都可能出问题，无论做什么都加锁，自然会很影响性能

乐观锁：

- 认为什么时候都不会出现问题，所以不会上锁，更新数据的时候去判断一下，在此期间是否有人修改过这个数据
- 获取Version
- 更新的时候比较version

> Redis的监视测试

```bash
# 正常情况 能执行成功
127.0.0.1:6379> set money 100
OK
127.0.0.1:6379> set out 0
OK
127.0.0.1:6379> watch money 
OK
127.0.0.1:6379> multi
OK
127.0.0.1:6379> DECRBY money 20
QUEUED
127.0.0.1:6379> INCRBY out 20
QUEUED
127.0.0.1:6379> exec
1) (integer) 80
2) (integer) 20
-------------------------------------------------------------------
# 多线程情况，使用watch可以当作redis的乐观锁使用
# 添加watch后就会记录当前的100，然后执行事务时就会去比较当前的money是不是100，如果不是就会发生错误。
127.0.0.1:6379> watch money
OK
127.0.0.1:6379> multi
OK
127.0.0.1:6379> DECRBY money 20
QUEUED
127.0.0.1:6379> INCRBY out 20
QUEUED
# 在执行之前另一条线程把money的值修改了，最后事务执行失败
127.0.0.1:6379> exec
(nil)
# 可以通过unwatch命令取消监视，如果发现事务执行失败了，就需要放弃原来的锁然后重新增加一个新的监视watch key
# exec执行的时候会比对当前值是不是之前监视的值，如果是的话就可以执行成功
127.0.0.1:6379> unwatch money
```

## Jedis

> 官方推荐的JAVA连接工具，使用JAVA操作Redis的中间件，如果要使用JAVA操作Redis，必须熟悉Jedis

```xml
<!--导入对应的依赖-->
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>3.3.0</version>
</dependency>
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.69</version>
</dependency
```

1.引入依赖

2.测试连接

```java
// 新建对象
Jedis jedis = new Jedis("127.0.0.1", 6379);
// jedis所有的命令就是之前学习的redis所有命令
System.out.println(jedis.ping());
// jedis所有的命令就是之前学习的redis所有命令
jedis.set("name", "zhangsan");
jedis.set("pass", "123");
jedis.del("pass");
Set<String> keys = jedis.keys("*");
System.out.println(keys);
// 执行完操作后记得关闭连接
jedis.close();
```

3.常用API

String、list、set、hash、zset 与redis的命令一致

4.事务测试

```java
Transaction multi = jedis.multi();
try {
    multi.set("use1", jsonObject.toJSONString());
    multi.set("use2", jsonObject.toJSONString());
    multi.exec();   // 执行事务
} catch (Exception e) {
    multi.discard(); // 放弃事务
    e.printStackTrace();
} finally {
    System.out.println(jedis.get("use1"));
    System.out.println(jedis.get("use2"));
    jedis.close(); // 关闭连接
}
```

## SpringBoot整合Redis

Spring-data

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<!-- 
	springboot2.0之后之前的jedis就被替换成lettuce
	jedis底层采用的是直接连接，多线程情况下是不安全的，如果要避免的话就需要用到jedis pool连接池
 	lettuce底层采用netty，实例可以在多个线程情况下实现共享，不存在线程不安全的情况，可以减少线程数据。
-->
<dependency>
    <groupId>io.lettuce</groupId>
    <artifactId>lettuce-core</artifactId>
    <version>6.1.3.RELEASE</version>
    <scope>compile</scope>
</dependency>
```

springboot所有的配置，都有一个自动配置类

自动配置类都会绑定一个properties配置文件

```java
// org.springframework.boot.autoconfigure.data.redis.RedisProperties（能配置的项）
// org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
@Bean
@ConditionalOnMissingBean(name = "redisTemplate")// 当这个bean不存在的时候生效，我们可以自己定义一个redisTemplate
@ConditionalOnSingleCandidate(RedisConnectionFactory.class)
public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    // 默认的RedisTemplate，Redis对象都是需要序列化的
    // 两个类型都是Object类型，后面使用的时候需要强制转化
    RedisTemplate<Object, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
}
@Bean
@ConditionalOnMissingBean
@ConditionalOnSingleCandidate(RedisConnectionFactory.class)
public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    // 由于String类型是redis中经常使用的类型，所以这里单独提出来一个方法
    StringRedisTemplate template = new StringRedisTemplate();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
}
```

```java
// 实操
// 操作字符串
ValueOperations valueOperations = redisTemplate.opsForValue();
// 操作list
ListOperations listOperations = redisTemplate.opsForList();
SetOperations setOperations = redisTemplate.opsForSet();
HashOperations hashOperations = redisTemplate.opsForHash();
// ....
// 获取redis连接对象
RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
connection.flushDb();
// 操作list
RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
connection.flushDb();
ValueOperations valueOperations = redisTemplate.opsForValue();
valueOperations.set("name", "lisi");
System.out.println(valueOperations.get("name"));
```

```java
// RedisTemplate 对值进行序列化操作配置
@SuppressWarnings("rawtypes") private @Nullable RedisSerializer keySerializer = null;
@SuppressWarnings("rawtypes") private @Nullable RedisSerializer valueSerializer = null;
@SuppressWarnings("rawtypes") private @Nullable RedisSerializer hashKeySerializer = null;
@SuppressWarnings("rawtypes") private @Nullable RedisSerializer hashValueSerializer = null;
// 默认通过JDK的方式来进行序列化，我们可以使用json来实现序列化
defaultSerializer = new JdkSerializationRedisSerializer(
					classLoader != null ? classLoader : this.getClass().getClassLoader());
```

```java
// 关于对象的保存需要序列化
// 序列化操作的效果 
@Test
public void test2() throws JsonProcessingException {
    // 真实的开发过程中对象需要进行序列化
    User user = new User("张三", 3);
    String jsonUser = new ObjectMapper().writeValueAsString(user);
    redisTemplate.opsForValue().set("user",jsonUser);
    System.out.println(redisTemplate.opsForValue().get("user"));
}
// 输出{"name":"张三","age":3}，这里输出的是对象的json格式
// 直接传递对象的话
@Test
public void test3() throws JsonProcessingException {
    // 真实的开发过程中对象需要进行序列化
    User user = new User("张三", 3);
    redisTemplate.opsForValue().set("user",user);
    System.out.println(redisTemplate.opsForValue().get("user"));
}
// 报错 Cannot serialize;
// 如果此时User对象实现Serializable接口的话，输出User(name=张三, age=3)，这里输出的是对象的toString方法
```

```java
// 自定义RedisTemplate
@Configuration
public class RedisConfig {
    // 编写自己的redisTemplate
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 直接使用String，Object
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer =
                new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        objectJackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // Key采用String序列化
        template.setKeySerializer(stringRedisSerializer);
        // HashKey采用String序列化
        template.setHashKeySerializer(stringRedisSerializer);
        // Value采用Jackson序列化
        template.setValueSerializer(objectJackson2JsonRedisSerializer);
        // HashValue采用Jackson序列化
        template.setHashValueSerializer(objectJackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }
}
```

## Redis.conf配置文件详解

```bash
# 单位 忽略大小写
# it in the usual form of 1k 5GB 4M and so forth:
#
# 1k => 1000 bytes
# 1kb => 1024 bytes
# 1m => 1000000 bytes
# 1mb => 1024*1024 bytes
# 1g => 1000000000 bytes
# 1gb => 1024*1024*1024 bytes
#
# units are case insensitive so 1GB 1Gb 1gB are all the same.

################################## INCLUDES ###################################
# 包含，可以导入一些其他的配置文件
# Include one or more other config files here.  This is useful if you
# have a standard template that goes to all Redis servers but also need
# to customize a few per-server settings.  Include files can include
# other files, so use this wisely.
#
# Notice option "include" won't be rewritten by command "CONFIG REWRITE"
# from admin or Redis Sentinel. Since Redis always uses the last processed
# line as value of a configuration directive, you'd better put includes
# at the beginning of this file to avoid overwriting config change at runtime.
#
# If instead you are interested in using includes to override configuration
# options, it is better to use include as the last line.
#
# include /path/to/local.conf
# include /path/to/other.conf

################################## NETWORK #####################################
# 网络，绑定的ip，是否受保护，端口
# By default, if no "bind" configuration directive is specified, Redis listens
# for connections from all the network interfaces available on the server.
# It is possible to listen to just one or multiple selected interfaces using
# the "bind" configuration directive, followed by one or more IP addresses.
#
# Examples:
#
# bind 192.168.1.100 10.0.0.1
# bind 127.0.0.1 ::1
#
# ~~~ WARNING ~~~ If the computer running Redis is directly exposed to the
# internet, binding to all the interfaces is dangerous and will expose the
# instance to everybody on the internet. So by default we uncomment the
# following bind directive, that will force Redis to listen only into
# the IPv4 loopback interface address (this means Redis will be able to
# accept connections only from clients running into the same computer it
# is running).
#
# IF YOU ARE SURE YOU WANT YOUR INSTANCE TO LISTEN TO ALL THE INTERFACES
# JUST COMMENT THE FOLLOWING LINE.
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
bind 127.0.0.1
# Protected mode is a layer of security protection, in order to avoid that
# Redis instances left open on the internet are accessed and exploited.
#
# When protected mode is on and if:
#
# 1) The server is not binding explicitly to a set of addresses using the
#    "bind" directive.
# 2) No password is configured.
#
# The server only accepts connections from clients connecting from the
# IPv4 and IPv6 loopback addresses 127.0.0.1 and ::1, and from Unix domain
# sockets.
#
# By default protected mode is enabled. You should disable it only if
# you are sure you want clients from other hosts to connect to Redis
# even if no authentication is configured, nor a specific set of interfaces
# are explicitly listed using the "bind" directive.
protected-mode yes
# Accept connections on the specified port, default is 6379 (IANA #815344).
# If port 0 is specified Redis will not listen on a TCP socket.
port 6379
################################# GENERAL #####################################
# 通用配置
# By default Redis does not run as a daemon. Use 'yes' if you need it.
# Note that Redis will write a pid file in /var/run/redis.pid when daemonized.
# 是否以守护进程的方式运行，默认是no，需要手动开启yes
daemonize yes

# If you run Redis from upstart or systemd, Redis can interact with your
# supervision tree. Options:
#   supervised no      - no supervision interaction
#   supervised upstart - signal upstart by putting Redis into SIGSTOP mode
#   supervised systemd - signal systemd by writing READY=1 to $NOTIFY_SOCKET
#   supervised auto    - detect upstart or systemd method based on
#                        UPSTART_JOB or NOTIFY_SOCKET environment variables
# Note: these supervision methods only signal "process is ready."
#       They do not enable continuous liveness pings back to your supervisor.
# 管理守护进程
supervised no

# If a pid file is specified, Redis writes it where specified at startup
# and removes it at exit.
#
# When the server runs non daemonized, no pid file is created if none is
# specified in the configuration. When the server is daemonized, the pid file
# is used even if not specified, defaulting to "/var/run/redis.pid".
#
# Creating a pid file is best effort: if Redis is not able to create it
# nothing bad happens, the server will start and run normally.
# 如果以后台守护进程的方式运行，就需要指定一个进程的pid文件
pidfile /var/run/redis_6379.pid

# Specify the server verbosity level.
# This can be one of:
# debug (a lot of information, useful for development/testing)
# verbose (many rarely useful info, but not a mess like the debug level)
# notice (moderately verbose, what you want in production probably)
# warning (only very important / critical messages are logged)
# 日志级别（默认生产环境）
loglevel notice

# Specify the log file name. Also the empty string can be used to force
# Redis to log on the standard output. Note that if you use standard
# output for logging but daemonize, logs will be sent to /dev/null
# 日志生成文件名
logfile ""

# Set the number of databases. The default database is DB 0, you can select
# a different one on a per-connection basis using SELECT <dbid> where
# dbid is a number between 0 and 'databases'-1
# 数据库数量，默认16个
databases 16

# By default Redis shows an ASCII art logo only when started to log to the
# standard output and if the standard output is a TTY. Basically this means
# that normally a logo is displayed only in interactive sessions.
#
# However it is possible to force the pre-4.0 behavior and always show a
# ASCII art logo in startup logs by setting the following option to yes.
# 是否显示log
always-show-logo yes

################################ SNAPSHOTTING  ################################
# 快照，做持久化时用到，在规定的时间里执行了多少操作则生成持久化文件，有.rdb、.aof文件
# Save the DB on disk:
#
#   save <seconds> <changes>
#
#   Will save the DB if both the given number of seconds and the given
#   number of write operations against the DB occurred.
#
#   In the example below the behaviour will be to save:
#   after 900 sec (15 min) if at least 1 key changed
#   after 300 sec (5 min) if at least 10 keys changed
#   after 60 sec if at least 10000 keys changed
#
#   Note: you can disable saving completely by commenting out all "save" lines.
#
#   It is also possible to remove all the previously configured save
#   points by adding a save directive with a single empty string argument
#   like in the following example:
#
#   save ""
# 规则，redis是内存数据库，如果没有对数据做持久化，关机就没了，在当下执行了
# 如果900秒内对一个key进行了修改，那就进行持久化操作
save 900 1
# 如果300秒内对十个key进行了修改，那就进行持久化操作
save 300 10
# 如果360秒内对一万个key进行了修改，那就进行持久化操作
save 60 10000

# By default Redis will stop accepting writes if RDB snapshots are enabled
# (at least one save point) and the latest background save failed.
# This will make the user aware (in a hard way) that data is not persisting
# on disk properly, otherwise chances are that no one will notice and some
# disaster will happen.
#
# If the background saving process will start working again Redis will
# automatically allow writes again.
#
# However if you have setup your proper monitoring of the Redis server
# and persistence, you may want to disable this feature so that Redis will
# continue to work as usual even if there are problems with disk,
# permissions, and so forth.
# 持久化时发生错误是否还要继续工作，默认继续
stop-writes-on-bgsave-error yes

# Compress string objects using LZF when dump .rdb databases?
# For default that's set to 'yes' as it's almost always a win.
# If you want to save some CPU in the saving child set it to 'no' but
# the dataset will likely be bigger if you have compressible values or keys.
# 是否压缩rdb资源文件，需要消耗一些CPU资源
rdbcompression yes

# Since version 5 of RDB a CRC64 checksum is placed at the end of the file.
# This makes the format more resistant to corruption but there is a performance
# hit to pay (around 10%) when saving and loading RDB files, so you can disable it
# for maximum performances.
#
# RDB files created with checksum disabled have a checksum of zero that will
# tell the loading code to skip the check.
# 保存RDB文件时进行错误校验、检查
rdbchecksum yes

# Since version 5 of RDB a CRC64 checksum is placed at the end of the file.
# This makes the format more resistant to corruption but there is a performance
# hit to pay (around 10%) when saving and loading RDB files, so you can disable it
# for maximum performances.
#
# RDB files created with checksum disabled have a checksum of zero that will
# tell the loading code to skip the check.
rdbchecksum yes

# The filename where to dump the DB 默认的保存文件名
dbfilename dump.rdb


# The working directory.
#
# The DB will be written inside this directory, with the filename specified
# above using the 'dbfilename' configuration directive.
#
# The Append Only File will also be created inside this directory.
#
# Note that you must specify a directory here, not a file name.
# RDB文件保存的目录，默认当前目录
dir ./

################################# REPLICATION #################################
# 主从复制
# Master-Replica replication. Use replicaof to make a Redis instance a copy of
# another Redis server. A few things to understand ASAP about Redis replication.
#
#   +------------------+      +---------------+
#   |      Master      | ---> |    Replica    |
#   | (receive writes) |      |  (exact copy) |
#   +------------------+      +---------------+
#
# 1) Redis replication is asynchronous, but you can configure a master to
#    stop accepting writes if it appears to be not connected with at least
#    a given number of replicas.
# 2) Redis replicas are able to perform a partial resynchronization with the
#    master if the replication link is lost for a relatively small amount of
#    time. You may want to configure the replication backlog size (see the next
#    sections of this file) with a sensible value depending on your needs.
# 3) Replication is automatic and does not need user intervention. After a
#    network partition replicas automatically try to reconnect to masters
#    and resynchronize with them.
#
# replicaof <masterip> <masterport>

################################## SECURITY ###################################
# 安全
# Require clients to issue AUTH <PASSWORD> before processing any other
# commands.  This might be useful in environments in which you do not trust
# others with access to the host running redis-server.
#
# This should stay commented out for backward compatibility and because most
# people do not need auth (e.g. they run their own servers).
#
# Warning: since Redis is pretty fast an outside user can try up to
# 150k passwords per second against a good box. This means that you should
# use a very strong password otherwise it will be very easy to break.
# 设置redis的登录密码
# requirepass foobared
requirepass 123456
----------------------------------------------------------------------------------------------
127.0.0.1:6379> ping
PONG
127.0.0.1:6379> get requirepass
(nil)
127.0.0.1:6379> config get requirepass
1) "requirepass"
2) ""
127.0.0.1:6379> config set requirepass "123"
OK
127.0.0.1:6379> config get requirepass # 设置完密码后没有登录的情况下所有的命令都不能正常使用了
(error) NOAUTH Authentication required.
127.0.0.1:6379> ping
(error) NOAUTH Authentication required.
127.0.0.1:6379> auth 123
OK
127.0.0.1:6379> config get requirepass
1) "requirepass"
2) "123"
----------------------------------------------------------------------------------------------
# Command renaming.
#
# It is possible to change the name of dangerous commands in a shared
# environment. For instance the CONFIG command may be renamed into something
# hard to guess so that it will still be available for internal-use tools
# but not available for general clients.
# 默认密码是空的
# Example:

################################### CLIENTS ####################################
# 客户端
# Set the max number of connected clients at the same time. By default
# this limit is set to 10000 clients, however if the Redis server is not
# able to configure the process file limit to allow for the specified limit
# the max number of allowed clients is set to the current file limit
# minus 32 (as Redis reserves a few file descriptors for internal uses).
#
# Once the limit is reached Redis will close all the new connections sending
# an error 'max number of clients reached'.
# 最大客户端数量，默认10000个客户端数量
# maxclients 10000

############################## MEMORY MANAGEMENT ################################
# 客户端的一些内存限制
# Set a memory usage limit to the specified amount of bytes.
# When the memory limit is reached Redis will try to remove keys
# according to the eviction policy selected (see maxmemory-policy).
#
# If Redis can't remove keys according to the policy, or if the policy is
# set to 'noeviction', Redis will start to reply with errors to commands
# that would use more memory, like SET, LPUSH, and so on, and will continue
# to reply to read-only commands like GET.
#
# This option is usually useful when using Redis as an LRU or LFU cache, or to
# set a hard memory limit for an instance (using the 'noeviction' policy).
#
# WARNING: If you have replicas attached to an instance with maxmemory on,
# the size of the output buffers needed to feed the replicas are subtracted
# from the used memory count, so that network problems / resyncs will
# not trigger a loop where keys are evicted, and in turn the output
# buffer of replicas is full with DELs of keys evicted triggering the deletion
# of more keys, and so forth until the database is completely emptied.
#
# In short... if you have replicas attached it is suggested that you set a lower
# limit for maxmemory so that there is some free RAM on the system for replica
# output buffers (but this is not needed if the policy is 'noeviction').
# redis配置的最大内存容量，默认是字节
# maxmemory <bytes>

# MAXMEMORY POLICY: how Redis will select what to remove when maxmemory
# is reached. You can select among five behaviors:
#
# volatile-lru -> Evict using approximated LRU among the keys with an expire set.只对过期时间的key进行LRU（默认值）
# allkeys-lru -> Evict any key using approximated LRU. 删除LRU算法的key
# volatile-lfu -> Evict using approximated LFU among the keys with an expire set.
# allkeys-lfu -> Evict any key using approximated LFU.
# volatile-random -> Remove a random key among the ones with an expire set. 随机删除即将过期的key
# allkeys-random -> Remove a random key, any key. 随机删除所有的key
# volatile-ttl -> Remove the key with the nearest expire time (minor TTL) 删除即将过期的
# noeviction -> Don't evict anything, just return an error on write operations. 永不过期，返回错误
#
# LRU means Least Recently Used
# LFU means Least Frequently Used
#
# Both LRU, LFU and volatile-ttl are implemented using approximated
# randomized algorithms.
#
# Note: with any of the above policies, Redis will return an error on write
#       operations, when there are no suitable keys for eviction.
#
#       At the date of writing these commands are: set setnx setex append
#       incr decr rpush lpush rpushx lpushx linsert lset rpoplpush sadd
#       sinter sinterstore sunion sunionstore sdiff sdiffstore zadd zincrby
#       zunionstore zinterstore hset hsetnx hmset hincrby incrby decrby
#       getset mset msetnx exec sort
#
# The default is:
# 内存达到上限后的处理策略
# maxmemory-policy noeviction

############################## APPEND ONLY MODE ###############################
# AOF配置
# By default Redis asynchronously dumps the dataset on disk. This mode is
# good enough in many applications, but an issue with the Redis process or
# a power outage may result into a few minutes of writes lost (depending on
# the configured save points).
#
# The Append Only File is an alternative persistence mode that provides
# much better durability. For instance using the default data fsync policy
# (see later in the config file) Redis can lose just one second of writes in a
# dramatic event like a server power outage, or a single write if something
# wrong with the Redis process itself happens, but the operating system is
# still running correctly.
#
# AOF and RDB persistence can be enabled at the same time without problems.
# If the AOF is enabled on startup Redis will load the AOF, that is the file
# with the better durability guarantees.
#
# Please check http://redis.io/topics/persistence for more information.
# 默认不开启AOF模式，默认只用RDB来做持久化，在大部分情况下RDB模式就够用了
appendonly no
# The name of the append only file (default: "appendonly.aof")
# 持久化的文件名
appendfilename "appendonly.aof"
# The fsync() call tells the Operating System to actually write data on disk
# instead of waiting for more data in the output buffer. Some OS will really flush
# data on disk, some other OS will just try to do it ASAP.
#
# Redis supports three different modes:
#
# no: don't fsync, just let the OS flush the data when it wants. Faster.
# always: fsync after every write to the append only log. Slow, Safest.
# everysec: fsync only one time every second. Compromise.
#
# The default is "everysec", as that's usually the right compromise between
# speed and data safety. It's up to you to understand if you can relax this to
# "no" that will let the operating system flush the output buffer when
# it wants, for better performances (but if you can live with the idea of
# some data loss consider the default persistence mode that's snapshotting),
# or on the contrary, use "always" that's very slow but a bit safer than
# everysec.
#
# More details please check the following article:
# http://antirez.com/post/redis-persistence-demystified.html
#
# If unsure, use "everysec".

# appendfsync always  # 每执行一次就同步sync 消耗性能
appendfsync everysec # 每秒都执行一次同步sync，但是可能这一次的值会丢失，
# appendfsync no    # 不执行同步，这个时候操作系统自己同步数据，速度是最快的。

# When the AOF fsync policy is set to always or everysec, and a background
# saving process (a background save or AOF log background rewriting) is
# performing a lot of I/O against the disk, in some Linux configurations
# Redis may block too long on the fsync() call. Note that there is no fix for
# this currently, as even performing fsync in a different thread will block
# our synchronous write(2) call.
#
# In order to mitigate this problem it's possible to use the following option
# that will prevent fsync() from being called in the main process while a
# BGSAVE or BGREWRITEAOF is in progress.
#
# This means that while another child is saving, the durability of Redis is
# the same as "appendfsync none". In practical terms, this means that it is
# possible to lose up to 30 seconds of log in the worst scenario (with the
# default Linux settings).
#
# If you have latency problems turn this to "yes". Otherwise leave it as
# "no" that is the safest pick from the point of view of durability.
# redis AOF默认不重写，文件会无限追加
no-appendfsync-on-rewrite no

# Automatic rewrite of the append only file.
# Redis is able to automatically rewrite the log file implicitly calling
# BGREWRITEAOF when the AOF log size grows by the specified percentage.
#
# This is how it works: Redis remembers the size of the AOF file after the
# latest rewrite (if no rewrite has happened since the restart, the size of
# the AOF at startup is used).
#
# This base size is compared to the current size. If the current size is
# bigger than the specified percentage, the rewrite is triggered. Also
# you need to specify a minimal size for the AOF file to be rewritten, this
# is useful to avoid rewriting the AOF file even if the percentage increase
# is reached but it is still pretty small.
#
# Specify a percentage of zero in order to disable the automatic AOF
# rewrite feature.
# redis会判断文件大小，如果这个文件大于了64MB，这时候就会fork一个新的进程来将文件进行重写
auto-aof-rewrite-percentage 100
auto-aof-rewrite-min-size 64mb

################################# REPLICATION #################################
# 主机从机配置
# Master-Replica replication. Use replicaof to make a Redis instance a copy of
# another Redis server. A few things to understand ASAP about Redis replication.
#
#   +------------------+      +---------------+
#   |      Master      | ---> |    Replica    |
#   | (receive writes) |      |  (exact copy) |
#   +------------------+      +---------------+
#
# 1) Redis replication is asynchronous, but you can configure a master to
#    stop accepting writes if it appears to be not connected with at least
#    a given number of replicas.
# 2) Redis replicas are able to perform a partial resynchronization with the
#    master if the replication link is lost for a relatively small amount of
#    time. You may want to configure the replication backlog size (see the next
#    sections of this file) with a sensible value depending on your needs.
# 3) Replication is automatic and does not need user intervention. After a
#    network partition replicas automatically try to reconnect to masters
#    and resynchronize with them.
# 配置主机的地址、端口
# replicaof <masterip> <masterport>

# If the master is password protected (using the "requirepass" configuration
# directive below) it is possible to tell the replica to authenticate before
# starting the replication synchronization process, otherwise the master will
# refuse the replica request.
# 如果主机有密码的话
# masterauth <master-password>

# When a replica loses its connection with the master, or when the replication
# is still in progress, the replica can act in two different ways:
#
# 1) if replica-serve-stale-data is set to 'yes' (the default) the replica will
#    still reply to client requests, possibly with out of date data, or the
#    data set may just be empty if this is the first synchronization.
#
# 2) if replica-serve-stale-data is set to 'no' the replica will reply with
#    an error "SYNC with master in progress" to all the kind of commands
#    but to INFO, replicaOF, AUTH, PING, SHUTDOWN, REPLCONF, ROLE, CONFIG,
#    SUBSCRIBE, UNSUBSCRIBE, PSUBSCRIBE, PUNSUBSCRIBE, PUBLISH, PUBSUB,
#    COMMAND, POST, HOST: and LATENCY.
#
replica-serve-stale-data yes

# You can configure a replica instance to accept writes or not. Writing against
# a replica instance may be useful to store some ephemeral data (because data
# written on a replica will be easily deleted after resync with the master) but
# may also cause problems if clients are writing to it because of a
# misconfiguration.
#
# Since Redis 2.6 by default replicas are read-only.

```

## Redis持久化

Redis是内存数据库，如果不将数据保存到硬盘中，断电即失

### RDB(Redis DataBase)：

是Redis DataBase缩写快照 

RDB是Redis默认的持久化方式。按照一定的时间将内存的数据以快照的形式保 存到硬盘中，对应产生的数据文件为dump.rdb。通过配置文件中的save参数来 定义快照的周期。

![RDB](E:\NetFile\QQfile\344796884\FileRecv\03-2020最新整理一线大厂面试题合集(重点看)\12-Redis面试题（2020最新版）-重点.assets\RDB.png)

> 触发规则
>
> 1. save的规则满足的情况下，会自动触发生成rdb文件
> 2. 执行flushall命令，也会触发生成rdb文件
> 3. 退出redis也会生成rdb文件
>
> 如何恢复rdb文件？
>
> 只需要将rdb文件放在redis的启动目录下，redis启动的时候会自动检查dump.rdb文件
>
> ```bash
> # 查看存放的位置
> 127.0.0.1:6379> config get dir
> 1) "dir"
> 2) "/usr/local/bin"
> ```

**优点：**

1. 只有一个文件 dump.rdb，方便持久化。 
2. 容灾性好，一个文件可以保存到安全的磁盘。 
3. 性能优化，fork 子进程来完成写操作，让主进程继续处理命令(正常处理请求)，所以是  IO优化。使用单独子进程来进行持久化，主进程不会进行任何 IO 操作，保证了  redis 的高性能 
4. 相对于数据集大时，比 AOF 的启动效率更高。 

**缺点：**

1. 数据安全性低。RDB 是间隔一段时间进行持久化，如果持久化时间间隔之间 redis 发生故障，会发生数据丢失，最后一次的修改就丢失了。所以这种方式更适合数据要求不严谨的时候)
2. fork进程的时候会占用一定的内存空间
3. AOF（Append-only file)持久化方式： 是指所有的命令行记录以 redis 命令请求协议的格式完全持久化存储)保存为 aof 文件。 

### AOF(Append Only File)

以日志的形式将我们所有的写的命令都记录下来，相当于history，redis会在启动的时候读取文件里的命令重新构建数据。当两种方式同时开启时，数据恢复Redis会优先选择AOF恢复。

![image-20211115204358343](C:\Users\admin\AppData\Roaming\Typora\typora-user-images\image-20211115204358343.png)

如果apf文件有问题，redis是启动不起来的，redis提供了#redis-check-aof --fix 对aof文件进行修复

**优点：**

1. 数据安全，aof 持久化可以配置 appendfsync 属性，有 always，每进行一次 命令操作就记录到 aof 文件中一次。 
2. 通过 append 模式写文件，即使中途服务器宕机，可以通过 redis-checkaof 工具解决数据一致性问题。 
3. AOF 机制的 rewrite 模式。AOF 文件没被 rewrite 之前（文件过大时会对命令进行合并重写），可以手动删除其中的某些命令比如误操作的 flushall

**缺点： **

1. AOF 文件比 RDB 文件大，且恢复速度慢。 
2. 数据集大的时候，比 rdb 启动效率低。 

RDB和AOF的优缺点是什么？ 

- AOF文件比RDB更新频率高，优先使用AOF还原数据。 
- AOF比RDB更安全也更大 
- RDB性能比AOF好 
- 如果两个都配了优先加载AOF 

如何选择合适的持久化方式

- 一般来说， 如果想达到足以媲美PostgreSQL的数据安全性，你应该 同时使用两种持久化功能。在这种情况下，当 Redis 重启的时候会优先载 入AOF文件来恢复原始的数据，因为在通常情况下AOF文件保存的数据集 要比RDB文件保存的数据集要完整。 
- 如果你非常关心你的数据， 但仍然可以承受数分钟以内的数据丢失， 那么你可以只使用RDB持久化。 
- 有很多用户都只使用AOF持久化，但并不推荐这种方式，因为定时生成RDB快照（snapshot）非常便于进行数据库备份， 并且 RDB 恢复数据 集的速度也要比AOF恢复的速度要快，除此之外，使用RDB还可以避免 AOF程序的bug。 
- 如果你只希望你的数据在服务器运行的时候存在，你也可以不使用任 何持久化方式。 

Redis持久化数据和缓存怎么做扩容？

如果Redis被当做缓存使用，使用一致性哈希实现动态扩容缩容。

如果Redis被当做一个持久化存储使用，必须使用固定的keys-tonodes映射关系，节点的数量一旦确定不能变化。否则的话(即Redis节点需要动态变化的情况），必须使用可以在运行时进行数据再平衡的一套系统，而当前只有Redis集群可以做到这样。

## Redis发布订阅

```bash
# 订阅端	订阅一个频道
127.0.0.1:6379> SUBSCRIBE guoguo 
Reading messages... (press Ctrl-C to quit)
1) "subscribe"
2) "guoguo"
3) (integer) 
-- 等待读取推送的信息
# A窗口同时收到消息 
127.0.0.1:6379> SUBSCRIBE guoguo 
Reading messages... (press Ctrl-C to quit)
1) "subscribe"
2) "guoguo"
3) (integer) 1
1) "message"
2) "guoguo"
3) "hello, woshi zhangsan "
```

```bash
# 发送端，发送消息
127.0.0.1:6379> PUBLISH guoguo "hello, woshi zhangsan "
(integer) 1
```

> 实现原理
>
> 通过subscribe命令订阅某一个频道之后，就会在redis-server中维护一个字典，字典的键就是一个一个的频道，字典的值则是一个链表，链表中保存了所有订阅这个channel(频道)的客户端，subscribe命令的关键就是将客户端添加到给定频道的订阅列表中
>
> publish命令就是向订阅者发布消息，redis-server会使用给定的频道作为键，在它所维护的channel字典中查到记录订阅了这个频道的客户端链表，遍历这个链表，将消息发送给所有订阅者
>
> 1 实时消息系统
>
> 2 实时聊天
>
> 3 订阅、关注系统

## Redis主从复制

### 概念

单机的 redis，能够承载的 QPS 大概就在上万到几万不等。对于缓存来说，一般都是用来支撑读高并发的。因此架构做成主从(master-slave)架构，一主多

从，主负责写，并且将数据复制到其它的 slave 节点，从节点负责读。所有的读请求全部走从节点。这样也可以很轻松实现水平扩容，支撑读高

本质上主机和从机都是redis-server，数据的复制只能是单向的，主从复制，读写分离，减缓服务器压力。

主从复制的主要作用：

1.数据冗余，主从复制实现了数据的热备份，是持久化之外的一种数据冗余方式

2.故障恢复，当主节点出现问题的时候，可以由从节点提供服务，实现故障的快速修复，

3.负载均衡，读写分离，可以由主节点提供写服务，从节点提供都服务，分担负载，尤其是在写少读多的情况下，可以通过多个从节点分担负载

4.高可用基石，主从复制是哨兵模式和集群能够实施的基础，也算是实现了redis高可用的基础。

一般最基本的都需要一主二从

默认的redis服务都是主节点

### 环境配置

```bash
127.0.0.1:6379> info replication
# Replication 查看当前库信息
role:master	# 角色 默认是master
connected_slaves:0 # 默认没有从机
master_replid:5ed73bdde65829a9bd3962ffd3447082c09fb1ea
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:0
second_repl_offset:-1
repl_backlog_active:0
repl_backlog_size:1048576
repl_backlog_first_byte_offset:0
repl_backlog_histlen:0
# 修改配置文件
[root@localhost redisconfig]# ll
总用量 256
-rw-r--r--. 1 root root 61798 11月 20 17:00 redis79.conf
-rw-r--r--. 1 root root 61798 11月 20 17:00 redis80.conf
-rw-r--r--. 1 root root 61798 11月 20 17:00 redis81.conf
-rw-r--r--. 1 root root 61798 10月 13 20:26 redis.conf
# 需要改动的地方
端口 port 6380
pidfile /var/run/redis_6380.pid
logfile "6380.log"
dbfilename dump6381.rdb
# 启动三个redis服务
[root@localhost bin]# ps -aux|grep redis
root       1585  0.1  0.4 167308 18224 ?        Ssl  15:57   0:06 ./redis-server 127.0.0.1:6379
root       1891  0.1  0.1 153992  7660 ?        Ssl  17:11   0:00 redis-server 127.0.0.1:6380
root       1896  0.6  0.1 153992  7664 ?        Ssl  17:11   0:00 redis-server 127.0.0.1:6381
```

指定一主（79）二从（80、81）

```bash
127.0.0.1:6380> slaveof 127.0.0.1 6379 # 配置主机slaveof host port
OK
127.0.0.1:6380> info replication
# Replication 库信息
role:slave # 角色 从机
master_host:127.0.0.1
master_port:6379
master_link_status:up
master_last_io_seconds_ago:1
master_sync_in_progress:0
slave_repl_offset:28
slave_priority:100
slave_read_only:1
connected_slaves:0
master_replid:1d0d5e10f9320c2fde15d4708211fa65ea68aa3a
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:28
second_repl_offset:-1
repl_backlog_active:1
repl_backlog_size:1048576
repl_backlog_first_byte_offset:1
repl_backlog_histlen:28
# 此时在主机中可以查看到从机的信息
```

实际情况中是需要在配置文件中修改的，这样的话就是永久性的，通过命令配置的主从关系在断开连接后就失去主从关系了。

主要变成从机，立马就会从主机中拿到数据，

>  QA
>
> 1.主机可以写，但是从机只可以读，主机中的所有信息都会被从机保存
>
> ```bash
> 127.0.0.1:6380> set k1 v1 # 如果要在从机执行写操作的话就会报错
> (error) READONLY You can't write against a read only replica.
> ```
>
> 2. 主机断了的话从机默认情况下 还是从机，从机是依旧连接到主机的，但是就没有写操作了。等主机重新连接以后，从机依旧可以获得连接信息
> 3. 理想的情况下是，主机断了以后，默认通过一种方式在从机中选择一个作为新的主机，

### 主从复制原理

slave从节点启动成功连接到master主节点后会发送一个sync命令

Master接到命令后，启动后台的存盘进程，同时收集所有用于修改的命令，等后台进程执行完存盘后，master将传送整个数据文件到slave，并一次性完成同步，执行全量复制

所以保证了一旦从机连接了主机，就会执行一次性全量同步，保证主从数据的一致

### 两种模型

1.一主二从，两个从节点的主节点都是同一个节点

2.一主一从一从，第二从节点的连接主节点，第三从节点连接第二从节点

如果主机断开连接了，我们可以通过执行命令把从机变成主机，此时其他从节点可以手动连接到新的主节点，但是有个问题是如果原来的主机重新连接之后它与从机的连接关系也不存在了

```bash
127.0.0.1:6380> slaveof no one # 配置从机变主机
```

## 哨兵模式

（主服务器宕机以后自动选择一个新的主服务器）

> 概述

Redis从2.8以后提供了Sentinel（哨兵模式）架构来解决主服务器宕机以后自动切换主服务器的问题。

能够后台监控主机是否宕机，如果故障了根据投票数***自动将从机变成主机***。

Redis提供了哨兵的命令，它会独立运行，原理就是哨兵通过发送命令，等待Redis服务器响应，从而监控运行的多个Redis实例。

```bash
# redis-bin目录下存在一个redis-sentinel
# 在conf配置文件目录下新建一个哨兵配置文件
vi sentinel.conf
sentinel monitor 【被监控的名称】 host port 【1-主机挂了，slave投票让谁接替成为主机】
sentinel monitor myredis 127.0.0.1 6379 1
# 配置后启动哨兵
redis-sentinel redisconfig/sentinel.conf
```

哨兵有两个作用：

- 通过哨兵发送命令，让redis服务器返回监控其运行状态，包括主服务和从服务器
- 当哨兵检测到master主机宕机，会自动将slave切换成master，然后通过发布订阅模式通知到其他从服务器，修改配置文件，让他们切换主机

但是哨兵本身也可能会挂掉，为此，我们可以采用一种多哨兵模式进行监控，各个哨兵之间还会进行互相监控，这样就形成了多哨兵模式

假设主服务宕机，哨兵1先检测到这个结果了，系统并不会马上进行failover过程，仅仅是哨兵1主管的认为主服务不可用了，这个现象为***主观下线***，当后面的哨兵也检测到主服务不可用了，并且数量达到一定值时，（可以确认主服务器真的不可用了），这时哨兵之间就会进行一次投票，投票的结果由一个哨兵发起，进行failover【故障转移】操作，切换成功之后，就会通过***发布订阅***的模式，让各个哨兵把自己监控的从服务器实现切换主机，这个过程称之为***客观下线***。

哨兵模式的规则

当主机宕机后从机变成了新的主机，这个时候如果主机重新连接了，也只能作为是新主机下的一个从机

哨兵模式：

优点：

1. 哨兵集群基于主从复制，所有主从复制的优点它都有
2. 主从可以切换，故障可以转移，系统的可用性就会更好
3. 哨兵模式就是主从模式的升级，手动到自动，更加健壮

缺点：

1. Redis不容易实现在线扩容，集群容量一旦达到上限，扩容会很麻烦

2. 实现哨兵模式其实会很麻烦，有很多种选择

   ```bash
   # Example sentinel.conf  
     
   # 哨兵sentinel实例运行的端口 默认26379  
   port 26379  
     
   # 哨兵sentinel的工作目录  
   dir /tmp  
     
   # 哨兵sentinel监控的redis主节点的 ip port   
   # master-name  可以自己命名的主节点名字 只能由字母A-z、数字0-9 、这三个字符".-_"组成。  
   # quorum 当这些quorum个数sentinel哨兵认为master主节点失联 那么这时 客观上认为主节点失联了  
   # sentinel monitor <master-name> <ip> <redis-port> <quorum>  
     sentinel monitor mymaster 127.0.0.1 6379 2  
     
   # 当在Redis实例中开启了requirepass foobared 授权密码 这样所有连接Redis实例的客户端都要提供密码  
   # 设置哨兵sentinel 连接主从的密码 注意必须为主从设置一样的验证密码  
   # sentinel auth-pass <master-name> <password>  
   sentinel auth-pass mymaster MySUPER--secret-0123passw0rd  
     
     
   # 指定多少毫秒之后 主节点没有应答哨兵sentinel 此时 哨兵主观上认为主节点下线 默认30秒  
   # sentinel down-after-milliseconds <master-name> <milliseconds>  
   sentinel down-after-milliseconds mymaster 30000  
     
   # 这个配置项指定了在发生failover主备切换时最多可以有多少个slave同时对新的master进行 同步，  
   这个数字越小，完成failover所需的时间就越长，  
   但是如果这个数字越大，就意味着越 多的slave因为replication而不可用。  
   可以通过将这个值设为 1 来保证每次只有一个slave 处于不能处理命令请求的状态。  
   # sentinel parallel-syncs <master-name> <numslaves>  
   sentinel parallel-syncs mymaster 1  
     
     
     
   # 故障转移的超时时间 failover-timeout 可以用在以下这些方面：   
   #1. 同一个sentinel对同一个master两次failover之间的间隔时间。  
   #2. 当一个slave从一个错误的master那里同步数据开始计算时间。直到slave被纠正为向正确的master那里同步数据时。  
   #3.当想要取消一个正在进行的failover所需要的时间。    
   #4.当进行failover时，配置所有slaves指向新的master所需的最大时间。不过，即使过了这个超时，slaves依然会被正确配置为指向master，但是就不按parallel-syncs所配置的规则来了  
   # 默认三分钟  
   # sentinel failover-timeout <master-name> <milliseconds>  
   sentinel failover-timeout mymaster 180000  
     
   # SCRIPTS EXECUTION  
     
   #配置当某一事件发生时所需要执行的脚本，可以通过脚本来通知管理员，例如当系统运行不正常时发邮件通知相关人员。  
   #对于脚本的运行结果有以下规则：  
   #若脚本执行后返回1，那么该脚本稍后将会被再次执行，重复次数目前默认为10  
   #若脚本执行后返回2，或者比2更高的一个返回值，脚本将不会重复执行。  
   #如果脚本在执行过程中由于收到系统中断信号被终止了，则同返回值为1时的行为相同。  
   #一个脚本的最大执行时间为60s，如果超过这个时间，脚本将会被一个SIGKILL信号终止，之后重新执行。  
     
   #通知型脚本:当sentinel有任何警告级别的事件发生时（比如说redis实例的主观失效和客观失效等等），将会去调用这个脚本，  
   #这时这个脚本应该通过邮件，SMS等方式去通知系统管理员关于系统不正常运行的信息。调用该脚本时，将传给脚本两个参数，  
   #一个是事件的类型，  
   #一个是事件的描述。  
   #如果sentinel.conf配置文件中配置了这个脚本路径，那么必须保证这个脚本存在于这个路径，并且是可执行的，否则sentinel无法正常启动成功。  
   #通知脚本  
   # sentinel notification-script <master-name> <script-path>  
     sentinel notification-script mymaster /var/redis/notify.sh  
     
   # 客户端重新配置主节点参数脚本  
   # 当一个master由于failover而发生改变时，这个脚本将会被调用，通知相关的客户端关于master地址已经发生改变的信息。  
   # 以下参数将会在调用脚本时传给脚本:  
   # <master-name> <role> <state> <from-ip> <from-port> <to-ip> <to-port>  
   # 目前<state>总是“failover”,  
   # <role>是“leader”或者“observer”中的一个。   
   # 参数 from-ip, from-port, to-ip, to-port是用来和旧的master和新的master(即旧的slave)通信的  
   # 这个脚本应该是通用的，能被多次调用，不是针对性的。  
   # sentinel client-reconfig-script <master-name> <script-path>  
    sentinel client-reconfig-script mymaster /var/redis/reconfig.sh 
   ```

   

   

## Redis缓存穿透和雪崩

### 缓存穿透（查不到）

> ```bash
> #用户想要查询一个数据，发现redis内存数据库中没有，也就是缓存没有命中，于是会向持久层数据库查询，发现也没有，于是本次查询失败。
> #所以当有很多个用户的时候，如果缓存都没有命中（比如秒杀系统），于是就都会请求持久层的数据库，这样的话就会给数据库造成很大的压力，这时候就相当于出现了缓存穿透。
> ```
>
> #### 解决方案-布隆过滤器
>
> 一种数据结构，对所有可能查询的参数以hash的形式存储，在控制层先进行校验，不符合则丢弃，从而避免了对底层存在的查询压力。
>
> 就是引入了k(k>1)个相互独立的哈希函数，保证在给定的空间、误判率下，完成元素判重的过程。
>
> 它的优点是空间效率和查询时间都远远超过一般的算法，缺点是有一定的误识别率和删除困难。
>
> Bloom-Filter算法的核心思想就是利用多个不同的Hash函数来解决“冲突”。
>
> Hash存在一个冲突（碰撞）的问题，用同一个Hash得到的两个URL的值有可能相同。为了减少冲突，我们可以多引入几个Hash，如果通过其中的一个Hash值我们得出某元素不在集合中，那么该元素肯定不在集合中。只有在所有的Hash
>
> 函数告诉我们该元素在集合中时，才能确定该元素存在于集合中。这便是
>
> Bloom-Filter的基本思想。
>
> Bloom-Filter一般用于在大数据量的集合中判定某元素是否存在。
>
> 布隆过滤器存在的两个问题：
>
> 1.如果空值能够被缓存起来，这就意味着需要更多的空间去存储更多的键，因为这当中可能会有很多空值的键
>
> 2.即使对空值设置了过期时间，还是会存在缓存层和存储层的数据会有一段时间窗口的不一致，这对于需要保持一致性的业务来讲会有所影响。



### 缓存击穿（查到，量大，缓存过期）

> 指在内存中的一个key，非常火爆，高并发集中对一个点进行访问，当这个key在失效的瞬间，持续的高并发就会穿破缓存，直接请求数据库，就像在屏幕中间凿开一个洞。
>
> 某一个key在过期的瞬间，有大量的请求并发访问，由于缓存过期，会同时访问数据库来查询最新的数据，并写回缓存，这回导致数据库压力过大。
>
> #### 解决方案
>
> 1.设置热点数据永远不过期。
>
> 2.加互斥锁，互斥锁缓存预热
>
> 缓存预热就是系统上线后，将相关的缓存数据直接加载到缓存系统。这样就可以避免在用户请求的时候，先查询数据库，然后再将数据缓存的问题！用户直接查询事先被预热的缓存数据！解决方案
>
> 1. 直接写个缓存刷新页面，上线时手工操作一下；
>
> 2. 数据量不大，可以在项目启动的时候自动进行加载；
>
> 3. 定时刷新缓存；

### 缓存雪崩

> 缓存雪崩，是指在某一个时间段内，缓存集中过期失效，Redis宕机。
>
> 产生雪崩的原因之一，缓存集体过期，对于查询请求的压力就又落到了数据库中了，对于数据库而言，就会产生周期性的压力波峰，于是所有的请求都会到达存储层，存储层的调用量会暴增，造成存储层也会挂掉的情况。
>
> ####  
>
> REDIS高可用
>
> 限流降级
>
> 数据预热

