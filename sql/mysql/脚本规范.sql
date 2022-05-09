-- mysql主键冲突解决方案
insert into stuTable (id, stuName, age) values (1, "zhangsan", 18) on duplicate key update stuName = "lisi", age = 17;
replace insert into stuTable (id, stuName, age) values (1, "zhangsan", 18)

-- 建表脚本
delimiter $$
drop procedure IF EXISTS basicexecutUpdateSql $$
create procedure basicexecutUpdateSql()
begin
    declare v_l_count int;
    SELECT COUNT(1) INTO v_l_count from INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = SCHEMA() and UPPER(TABLE_NAME) = UPPER('base_OrganRelated');
    IF v_l_count = 0 THEN
    create table base_OrganRelated (
        organRelatedId       INT(10) not null,
        institutionCode      VARCHAR(32),
        outerOrgId           INT(10),
        relatedDimension     INT(10),
        operatorCode         VARCHAR(64),
        createTime           BIGINT(14),
        updateTime           BIGINT(14),
        constraint PK_BASE_ORGANRELATED primary key (organRelatedId)
    );
    insert into base_OrganRelated select * from rmc_OrganRelated;
    END IF ;
end $$
call basicexecutUpdateSql() $$
drop procedure IF EXISTS basicexecutUpdateSql $$
delimiter ;

-- 修改字段脚本
delimiter $$
drop procedure IF EXISTS basicexecutUpdateSql $$
create procedure basicexecutUpdateSql()
begin
    declare v_rowcount int;
    select count(1) into v_rowcount from information_schema.columns
    where table_schema= SCHEMA() and
        UPPER(table_name)=UPPER('BASE_TABLELAYOUTINFO') and
        UPPER(column_name)=UPPER('ISENABLE');
    if v_rowcount = 1 then
    ALTER TABLE BASE_TABLELAYOUTINFO MODIFY COLUMN ISENABLE INT(1) not null;
    end if;
end $$
call basicexecutUpdateSql() $$
drop procedure IF EXISTS basicexecutUpdateSql $$
delimiter ;

-- 增加索引
delimiter $$
drop procedure IF EXISTS basicexecutUpdateSql $$
create procedure basicexecutUpdateSql()
begin
    declare v_rowcount int;
    SELECT count(1) INTO v_rowcount FROM information_schema.statistics WHERE table_name = UPPER('BASE_COUNTERPARTY') and index_name = UPPER('UK_base_Counterparty_CPCode');
    if v_rowcount = 0 then
            CREATE UNIQUE INDEX UK_base_Counterparty_CPCode ON BASE_COUNTERPARTY(COUNTERPARTYCODE ASC);
    end if;
end $$
call basicexecutUpdateSql() $$
drop procedure IF EXISTS basicexecutUpdateSql $$
delimiter ;

-- 数据增量脚本
delimiter $$
drop procedure IF EXISTS basicexecutUpdateSql $$
create procedure basicexecutUpdateSql()
begin
    DECLARE num INT;
    SELECT COUNT(*) INTO num FROM base_GlobalParam where institutionCode = '0' and globalParamId = 10001;
    IF(num=0) THEN
        INSERT INTO base_GlobalParam (institutionCode, globalParamId, globalParamName, globalParamMemo, globalParamClass, globalParamControlType, globalParamControlGetWay, globalParamControlValue, globalParamValue, onlyReadFlag, onlySeeFlag, updateTime, operatorCode, requiredFlag)
        VALUES ('0', 10001, 'MQ消息批量转全表发送阈值', 'MQ消息批量转全表发送阈值' , 2, 3, 4, '(0,2147483647]', '5000', '1', '0', 20211011000000, '0', 1);
    END IF;
end $$
call basicexecutUpdateSql() $$
drop procedure IF EXISTS basicexecutUpdateSql $$
delimiter ;