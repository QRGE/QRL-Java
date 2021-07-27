-- 先查出一张 emp-salary 表, 再查出一张 manager-salary 表, 最后再查 emp.salary > manager.salary 表
SELECT sem.emp_no AS emp_no, sdm.emp_no AS manager_no,
       sem.salary AS emp_salary, sdm.salary AS manager_salary
FROM (
    SELECT s.salary, s.emp_no, de.dept_no FROM salaries s INNER JOIN dept_emp de
    ON s.emp_no = de.emp_no AND s.to_date = '9999-01-01'
) AS sem,(
    SELECT s.salary, s.emp_no, dm.dept_no FROM salaries s INNER JOIN dept_manager dm
    ON s.emp_no = dm.emp_no AND s.to_date = '9999-01-01'
) AS sdm
WHERE sem.dept_no = sdm.dept_no AND sem.salary > sdm.salary