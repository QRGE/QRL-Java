# https://www.nowcoder.com/practice/32c53d06443346f4a2f2ca733c19660c?tpId=82&tags=&title=&difficulty=0&judgeStatus=0&rp=1

# 最先的想法即用 not in 找出不在dept_manager的emp_no
SELECT emp_no
FROM employees
WHERE emp_no NOT IN
      (SELECT emp_no from dept_manager);

# 从讨论中学到可以利用 join + null 判断
SELECT e.emp_no
from employees e
LEFT JOIN dept_manager d
on e.emp_no = d.emp_no
WHERE d.emp_no IS NULL
