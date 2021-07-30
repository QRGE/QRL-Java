-- https://www.nowcoder.com/practice/d6dd656483b545159d3aa89b4c26004e?tpId=82&&tqId=35083&rp=1&ru=/activity/oj&qru=/ta/sql/question-ranking
-- 正常用户发送给正常用户邮件的失败概率, 失败概率 = 失败数 / 发送右键总数
-- 需要根据日期分组, 注意题意
-- 直接 count(type='no_completed') 似乎不行
SELECT e.date, ROUND(COUNT(
     case when type='no_completed' then 1 else null END
 ) * 1.0 / COUNT(*), 3)
FROM email e JOIN user u
ON e.send_id != u.id AND e.receive_id = u.id
AND u.is_blacklist = 0
GROUP BY e.date