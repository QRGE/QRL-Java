-- https://www.nowcoder.com/practice/b9068bfe5df74276bd015b9729eec4bf?tpId=82&tags=&title=&difficulty=0&judgeStatus=0&rp=1
SELECT s1.emp_no, s1.salary, COUNT(DISTINCT s2.salary) AS `rank`
FROM salaries s1, salaries s2
WHERE s1.to_date = '9999-01-01' AND s2.to_date = '9999-01-01'
AND s1.salary <= s2.salary
GROUP BY s1.emp_no
ORDER BY s1.salary DESC, s1.emp_no ASC;