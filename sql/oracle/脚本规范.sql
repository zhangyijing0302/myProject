-- 新建表
declare
v_rowcount number(10);
begin
        select count(*) into v_rowcount from dual where exists(select * from user_objects where object_name = upper('base_OrganRelated'));
        if v_rowcount = 0 then
	    execute immediate 'CREATE TABLE base_OrganRelated (
               organRelatedId     NUMBER(10)  NOT NULL,
               institutionCode    VARCHAR2(32),
               outerOrgId         NUMBER(10),
               relatedDimension   NUMBER(10),
               operatorCode       VARCHAR2(64),
               createTime         NUMBER(14),
               updateTime         NUMBER(14),
               constraint PK_BASE_ORGANRELATED primary key (organRelatedId)
            )';
end if;
end;
/

-- 修改表字段
declare
v_rowcount integer;
begin
    select count(*) into v_rowcount from dual where exists (select * from col where tname = upper('OI_INSDETAILINFO') and cname = upper('ISLOCK'));
    if v_rowcount > 0 then
        execute immediate 'ALTER TABLE OI_INSDETAILINFO ADD ISLOCK_BAK NUMBER(1)';
        execute immediate 'UPDATE OI_INSDETAILINFO SET ISLOCK_BAK = to_number(ISLOCK)';
        execute immediate 'ALTER TABLE OI_INSDETAILINFO MODIFY ISLOCK_BAK not null';
        execute immediate 'ALTER TABLE OI_INSDETAILINFO DROP COLUMN ISLOCK';
        execute immediate 'ALTER TABLE OI_INSDETAILINFO RENAME COLUMN ISLOCK_BAK TO ISLOCK';
    end if;
end;
/

-- 增加索引
declare
v_rowcount integer;
begin
    select count(*) into v_rowcount from dual where exists (SELECT * from user_indexes WHERE table_name = upper('base_OuterOrganization') AND index_name = upper('IDX_OUTERORGCODE'));
    if v_rowcount = 0 then
        execute immediate 'CREATE UNIQUE INDEX IDX_OUTERORGCODE ON base_OuterOrganization (institutionCode, outerOrgCode)';
    end if;
end;
/

-- 修改数据
DECLARE v_rowcount NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_rowcount FROM dual WHERE EXISTS(SELECT 1 FROM base_templatedetail WHERE templateDetailId = 35);
    IF v_rowcount = 0 THEN
        INSERT INTO base_templatedetail(institutionCode, templateDetailId, templateId, marketBoard, templateType, templateStatus, fileStoragePath, origTemplatePath, createTime, updateTime, operatorCode, checkTime, checkResult, columnIndexMergeList, styleIdList)
        values ('0', 35, 1, '5', 4, 2, null, null, 20210728000000, 20210728000000, 'Croot', null, 2, null, '4');
    ELSIF v_rowcount = 1 THEN
        UPDATE base_templatedetail SET columnIndexMergeList=null,styleIdList='4'
        WHERE institutionCode='0' AND templateDetailId=35;
    END IF;
COMMIT;
END;
/