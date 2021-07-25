SELECT ee.last_name, ee.first_name, dd.dept_name
FROM (
    SELECT e.last_name, e.first_name, d.dept_no
    FROM employees e LEFT JOIN dept_emp d
    ON e.emp_no = d.emp_no) ee
LEFT JOIN departments dd
ON ee.dept_no = dd.dept_no;