show full PROCESSLIST

-- innodb事务表 查看当前正在运行中的事务
select * from information_schema.innodb_trx
kill #{mysql_thread_id}

-- 主键冲突三种解决方案
insert into student (id, stuname, age) values (1,"张三", 12) on duplicate key update stuname = '张三', age = 12;

insert ignore into student (id, stuname, age) values (1,"张三", 12);

replace into student  (id, stuname, age) values (1,"张三", 12);
