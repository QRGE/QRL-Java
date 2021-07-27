-- https://www.nowcoder.com/practice/6a62b6c0a7324350a6d9959fa7c21db3?tpId=82&tags=&title=&difficulty=0&judgeStatus=0&rp=1
SELECT a.dept_no, a.dept_name, b.sum
FROM departments a
INNER JOIN
(
 SELECT d.dept_no, COUNT(s.salary) AS `sum`
 FROM dept_emp d
          INNER JOIN salaries s
                     ON d.emp_no = s.emp_no
 GROUP BY(d.dept_no)
) b
ON a.dept_no = b.dept_no