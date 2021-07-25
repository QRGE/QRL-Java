-- https://www.nowcoder.com/practice/c8652e9e5a354b879e2a244200f1eaae?tpId=82&tqId=29767&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fsql%2Fquestion-ranking
SELECT t.title, avg(s.salary) AS avgSalary
FROM titles t INNER JOIN salaries s
ON t.emp_no = s.emp_no
GROUP BY(t.title)
ORDER BY avgSalary ASC