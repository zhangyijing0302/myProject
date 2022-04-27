-- 创建数据库
CREATE DATABASE otcdStandard DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

-- 创建用户
CREATE USER otcd IDENTIFIED BY 'otcd';
GRANT ALL PRIVILEGES ON otcdStandard.* TO otcd@'%';
FLUSH PRIVILEGES;


-- 连接mysql
-- mysql -h127.0.0.1 -uomsdb -P3306 -pomsdb --default-character-set=gbk