-- https://www.nowcoder.com/practice/fc7344ece7294b9e98401826b94c6ea5?tpId=82&tags=&title=&difficulty=0&judgeStatus=0&rp=1
-- 注意查询的是在职员工
-- 思路: 在职的最新薪水 - 入职薪水
SELECT a.emp_no, (a.nowSalary - b.firstSalary) AS growth
FROM
    (
        SELECT e.emp_no, s.salary AS nowSalary
        FROM employees e, salaries s
        WHERE e.emp_no = s.emp_no AND to_date = '9999-01-01'
    ) a
LEFT JOIN
    (
        SELECT e.emp_no, s.salary AS firstSalary
        FROM employees e, salaries s
        WHERE e.emp_no = s.emp_no AND e.hire_date = s.from_date
    ) b
    ON a.emp_no = b.emp_no
ORDER BY growth