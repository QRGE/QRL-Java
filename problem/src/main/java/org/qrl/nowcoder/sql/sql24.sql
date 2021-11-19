-- https://www.nowcoder.com/practice/8fe212a6c71b42de9c15c56ce354bebe?tpId=82&&tqId=29776&rp=1&ru=/activity/oj&qru=/ta/sql/question-ranking
SELECT a.dept_no, a.emp_no, a.salary
FROM
(
    SELECT e.emp_no, de.dept_no, s.salary
    FROM employees e, dept_emp de, salaries s
    where e.emp_no = de.emp_no AND e.emp_no = s.emp_no
) a
INNER JOIN dept_manager b
ON a.dept_no = b.dept_no AND a.emp_no != b.emp_no