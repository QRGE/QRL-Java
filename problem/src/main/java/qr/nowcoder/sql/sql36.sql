-- https://www.nowcoder.com/practice/881385f388cf4fe98b2ed9f8897846df?tpId=82&tags=&title=&difficulty=0&judgeStatus=0&rp=1
-- 建表的时候可以根据select的选择结果建表
-- 建表的三种常用方式:
--   常见方式: create table if not exists tableName
--   复制表: create table1 like table2
--   根据别的表的部分信息创建表 create table XX select A, B from table2
CREATE TABLE actor_name(
   first_name VARCHAR(45) NOT NULL,
   last_name VARCHAR(45) NOT NULL
)SELECT first_name, last_name FROM actor;