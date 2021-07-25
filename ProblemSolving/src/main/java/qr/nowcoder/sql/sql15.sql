-- https://www.nowcoder.com/practice/a32669eb1d1740e785f105fa22741d5c?tpId=82&&tqId=29767&rp=1&ru=/ta/sql&qru=/ta/sql/question-ranking
SELECT *
FROM employees
WHERE last_name != "Mary"
AND emp_no % 2 = 1
ORDER BY hire_date DESC;