merge into student using dual on (id = #{id})
when not matched then insert (id, stuname, age) values (1, '张三', 12)
when matched then update set stuname = '张三', age = 12;