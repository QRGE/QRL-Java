-- https://www.nowcoder.com/practice/b9db784b5e3d488cbd30bd78fdb2a862?tpId=82&tags=&title=&difficulty=0&judgeStatus=0&rp=1
-- CREATE VIEW xx AS xx 是创建视图的语法
CREATE VIEW actor_name_view (first_name_v, last_name_v) AS
SELECT first_name, last_name FROM actor
