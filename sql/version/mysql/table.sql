-- 学生表
delimiter $$
drop procedure IF EXISTS basicexecutUpdateSql $$
create procedure basicexecutUpdateSql()
    begin
    declare v_l_count int;
    SELECT COUNT(1) INTO v_l_count from INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = SCHEMA() and UPPER(TABLE_NAME) = UPPER('stuTable');
        IF v_l_count = 0 THEN
            CREATE TABLE stutable  (
                                       id int NOT NULL AUTO_INCREMENT,
                                       stuname varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                       age int NULL DEFAULT NULL,
                                       account decimal(20, 0) NULL DEFAULT NULL,
                                       PRIMARY KEY (id) USING BTREE
            ) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;
        END IF ;
    end $$
call basicexecutUpdateSql() $$
drop procedure IF EXISTS basicexecutUpdateSql $$
delimiter ;

