-- 学生表
DROP TABLE IF EXISTS stutable;
CREATE TABLE stutable  (
                           id int NOT NULL AUTO_INCREMENT,
                           stuname varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                           age int NULL DEFAULT NULL,
                           account decimal(20, 0) NULL DEFAULT NULL,
                           PRIMARY KEY (id) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
