-- https://www.nowcoder.com/practice/8d2c290cc4e24403b98ca82ce45d04db?tpId=82&&tqId=29769&rp=1&ru=/ta/sql&qru=/ta/sql/question-ranking
SELECT emp_no, salary
FROM salaries
LIMIT 1, 1

-- 看讨论后完善的结果, 满足有多人的工资为第二薪水的状况
SELECT emp_no, salary
FROM salaries
WHERE salary = (
    SELECT salary
    FROM salaries
    ORDER BY salary DESC
    LIMIT 1, 1
);