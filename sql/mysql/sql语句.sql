insert into student (id, stuname, age) values (1,"张三", 12)
on duplicate key update stuname = '张三', age = 12;
