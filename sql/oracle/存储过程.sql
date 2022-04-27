-- 创建存储过程
CREATE OR REPLACE PROCEDURE func_rationObjectVolume
AS
v_exchId                  VARCHAR2(30);
v_stkId                   VARCHAR2(30);
v_stkName                 VARCHAR2(1024);
v_rationObjectVolume      NUMBER;
v_listingDate             NUMBER;
v_holidayFlag             NUMBER;
listingDate_year          NUMBER;
listingDate_month         NUMBER;
listingDate_day           NUMBER;
lastListingDate           NUMBER;
index_count               NUMBER DEFAULT 10;
v_count               	  NUMBER;
stkName_temp                VARCHAR2(1024);
rationObjectVolume_temp      NUMBER;

-- 给游标存放数据
CURSOR cursor_l IS
-- 获取上市日
SELECT
    a.exchId as v_exchId,
    a.stkId as v_stkId,
    a.listingDate as v_listingDate
FROM base_IpoInfo a inner join ic_ValuationPosition b on a.INSTITUTIONCODE = b.INSTITUTIONCODE and a.EXCHID = b.EXCHID and a.STKID = b.STKID
WHERE a.listingDate IS NOT NULL AND a.listingDate > 0;

BEGIN
-- 打开游标
OPEN cursor_l;
-- 开始标记
LOOP
FETCH cursor_l INTO v_exchId, v_stkId, v_listingDate;
        EXIT WHEN cursor_l% NOTFOUND;

        -- 上市日前一日
        lastListingDate 	:= v_listingDate;
        listingDate_year  	:= TO_NUMBER(SUBSTR(to_char(v_listingDate), 1, 4));
        listingDate_month 	:= TO_NUMBER(SUBSTR(to_char(v_listingDate), 5, 2));
        listingDate_day   	:= TO_NUMBER(SUBSTR(to_char(v_listingDate), 7, 2));

execute immediate 'SELECT holidayFlag' || listingDate_day || '
        FROM base_ExchangeDate WHERE holidayTypeId = 0
        AND holidayYear = ' || listingDate_year || '
        AND holidayMonth = ' || listingDate_month || '' INTO v_holidayFlag ;

-- 获取上一交易日（最多获取10次，获取不到则不再获取）
WHILE index_count > 0 LOOP
            IF v_holidayFlag IS NOT NULL THEN
                IF listingDate_day = 1 THEN
                    IF listingDate_month <> 1 THEN
                        listingDate_month := listingDate_month - 1;
                        IF listingDate_month IN (1, 3, 5, 7, 8, 10, 12) THEN
                            listingDate_day := 31;
                        ELSIF listingDate_month IN (4, 6, 9, 11) THEN
                            listingDate_day := 30;
ELSE
                            listingDate_day := 28;
END IF;
ELSE
						listingDate_year := listingDate_year - 1;
						listingDate_month := 12;
						listingDate_day := 31;
END IF;
ELSE
                    listingDate_day := listingDate_day - 1;
END IF;

execute immediate 'SELECT holidayFlag' || listingDate_day || '
                FROM base_ExchangeDate WHERE holidayTypeId = 0
                AND holidayYear = ' || listingDate_year || '
				AND holidayMonth = ' || listingDate_month || '' INTO v_holidayFlag;

IF v_holidayFlag in (1, 3) THEN
                    index_count := 0;
END IF;
END IF;

            IF index_count = 0 THEN
                lastListingDate := TO_NUMBER(
									TO_CHAR(listingDate_year) ||
										(CASE WHEN LENGTH(listingDate_month) = 2 THEN TO_CHAR(listingDate_month)
											ELSE '0' || listingDate_month END) ||
												(CASE WHEN LENGTH(listingDate_day) = 2 THEN TO_CHAR(listingDate_day)
													ELSE '0' || listingDate_day END));
ELSE
                index_count := index_count - 1;
END IF;
END LOOP;

        IF lastListingDate <> v_listingDate THEN
SELECT COUNT(*) INTO v_count FROM dual where EXISTS
                                                 (SELECT 1 FROM ic_IPORationObjectStats WHERE INSTITUTIONCODE = '0' AND exchId = v_exchId AND stkId = v_stkId);
IF v_count > 0 THEN
				-- 更新
SELECT stkName into stkName_temp FROM ic_ValuationPosition WHERE institutionCode = '0'
                                                             AND businessDate = lastListingDate
                                                             AND exchId = v_exchId
                                                             AND stkId = v_stkId
                                                             AND closingVolume > 0;
SELECT COUNT(productId) into rationObjectVolume_temp FROM ic_ValuationPosition WHERE institutionCode = '0'
                                                                                 AND businessDate = lastListingDate
                                                                                 AND exchId = v_exchId
                                                                                 AND stkId = v_stkId
                                                                                 AND closingVolume > 0 GROUP BY exchId, stkId;
UPDATE ic_IPORationObjectStats SET
                                   stkName = (CASE WHEN stkName_temp IS NOT NULL THEN stkName_temp ELSE stkName END),
                                   rationObjectVolume = (CASE WHEN rationObjectVolume_temp IS NOT NULL THEN rationObjectVolume_temp ELSE rationObjectVolume END)
WHERE INSTITUTIONCODE = '0' AND exchId = v_exchId AND stkId = v_stkId;
ELSE
				-- 插入
				INSERT INTO ic_IPORationObjectStats (institutionCode, exchId, stkId, stkName, rationObjectVolume)
				(SELECT MAX(institutionCode), exchId, stkId, MAX(stkName) AS stkName,
					   COUNT(productId) AS rationObjectVolume
				FROM ic_ValuationPosition
				WHERE institutionCode = '0'
				  AND businessDate = lastListingDate
				  AND exchId = v_exchId
				  AND stkId = v_stkId
				  AND closingVolume > 0
				GROUP BY exchId, stkId);
END IF;
END IF;
		index_count := 10;
COMMIT;
END LOOP;
CLOSE cursor_l;
END;
/

-- 执行存储过程
CALL func_rationObjectVolume();
DROP PROCEDURE func_rationObjectVolume;

COMMIT;