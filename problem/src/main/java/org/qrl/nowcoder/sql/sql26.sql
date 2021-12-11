-- group by 是可以根据多个 column 查询的
SELECT a.dept_no AS dept_no, a.dept_name AS dept_name,
       a.title AS title , COUNT(a.emp_no) AS `count`
FROM(
    SELECT d.dept_no, d.dept_name, de.emp_no, t.title
    FROM departments d, dept_emp de, titles t
    WHERE de.to_date = '9999-01-01'AND d.dept_no = de.dept_no
      AND de.emp_no = t.emp_no
) a
GROUP BY dept_no, title
ORDER BY dept_no ASC