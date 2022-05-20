-- 创建数据库
CREATE DATABASE otcdStandard DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
CREATE DATABASE otcdt0 DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_unicode_ci;

-- 创建用户
CREATE USER otcdt0 IDENTIFIED BY 'otcdt0';
GRANT ALL PRIVILEGES ON otcdt0.* TO otcdt0@'%';
FLUSH PRIVILEGES;


-- 连接mysql
-- mysql -h127.0.0.1 -uomsdb -P3306 -pomsdb --default-character-set=gbk