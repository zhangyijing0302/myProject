tee 10_产品基础信息.log


-- 创建存储过程
DELIMITER $$

DROP PROCEDURE IF EXISTS func_Product$$
CREATE PROCEDURE func_Product()
BEGIN
DECLARE productId BIGINT(10);
DECLARE productinnerno BIGINT(10);
DECLARE productoutercode VARCHAR(256);
DECLARE productname VARCHAR(256);
DECLARE productfullname VARCHAR(256);
DECLARE producttype VARCHAR(3);
DECLARE productsontype VARCHAR(3);
DECLARE productstatus VARCHAR(3);
DECLARE opendate BIGINT(14);
DECLARE enddate BIGINT(14);
DECLARE investarea VARCHAR(3);
DECLARE cfetsid BIGINT(10);
DECLARE memo VARCHAR(1024);

-- 产品基础信息
DECLARE done INT DEFAULT false;
DECLARE cursor_l CURSOR FOR
SELECT
    a.l_fund_id         AS productinnerno,
    a.vc_fund_code      AS productoutercode,
    a.vc_fund_name      AS productname,
    a.vc_fund_caption   AS productfullname,
    (CASE
         WHEN a.c_fund_type = ''  THEN
             '01' -- 证券投资基金
         WHEN a.c_fund_type in ('8','5') THEN
             '02' -- 企业年金
         WHEN a.c_fund_type = '3' THEN
             '03' -- 社保基金
        -- WHEN a.c_fund_type = '8' THEN
        --     '04'  -- 职业年金
         WHEN a.c_fund_type = 'f' THEN
             '05'  -- 信托计划
        -- WHEN a.c_fund_type = ''  THEN
        --     '06'  -- 券商理财
        -- WHEN a.c_fund_type = ''  THEN
        --     '07'  -- 银行理财
        -- WHEN a.c_fund_type = 'g' THEN
        --     '08' -- 私募投资基金
         ELSE
             '01'
        END) AS producttype, -- TBD
    (CASE
         WHEN a.c_fund_type = '8' THEN
             '07' -- 年金计划
         WHEN a.c_fund_type = '5' THEN
             '09' -- 投资组合
         WHEN a.c_fund_type = 'f' THEN
             '13'  -- 单一信托计划
         ELSE
             '01'  -- 普通型
        END) AS productsontype,
    (CASE
         WHEN a.c_fund_status = '2' THEN
             '0' -- 正常
         WHEN a.c_fund_status = '5' THEN
             '1' -- 注销
         WHEN a.c_fund_status = '6' THEN
             '2' -- 冻结
         ELSE
             '0'
        END) AS productstatus,
    a.l_open_date * 1000000 AS opendate,
    a.l_end_date * 1000000 AS enddate,
    (CASE
         WHEN a.c_market_type = '1' THEN
             '0'
         WHEN a.c_market_type = '2' THEN
             '1'
         WHEN a.c_market_type = '3' THEN
             '2'
         ELSE
             '0'
        END) AS investarea,
    a.l_bank_id         AS cfetsid,
    a.vc_remarks        AS memo
FROM
    tfundinfo a; -- 定义游标cursor_l
DECLARE CONTINUE HANDLER FOR NOT FOUND  SET done = TRUE;

START TRANSACTION; -- 开启事务

OPEN cursor_l; -- 打开游标
read_loop: LOOP   -- 开始标记
      FETCH cursor_l INTO productinnerno, productoutercode, productname, productfullname, producttype, productsontype, productstatus, opendate, enddate, investarea, cfetsid, memo;  -- 游标赋值
      IF done THEN LEAVE read_loop;
END IF;

SELECT (currentValue + sequenceNum) INTO productId FROM base_Sequence WHERE seqName = 'productId';

INSERT INTO base_Product(institutionCode, productId, productInnerNo, productOuterCode, productName, spellList, productFullName, productType, productSonType, productStatus, openDate, endDate, localCurrencyId, investArea, investDirection, exchIdList, cfetsId, enableReckoningFlag, navCalPrecision, memo)
VALUES ('0', productId, productinnerno, productoutercode, productname, '', productfullname, producttype, productsontype, productstatus, opendate, enddate, 'CNY', investarea, '0', '', cfetsid, '0', 4, memo);

UPDATE base_Sequence SET currentValue = productId WHERE seqName = 'productId';
COMMIT;
END LOOP; -- 操作完成
CLOSE cursor_l;
COMMIT; -- 提交事务
END$$

DELIMITER ;

-- 执行存储过程
CALL func_Product();
DROP PROCEDURE IF EXISTS func_Product;

COMMIT;
notee