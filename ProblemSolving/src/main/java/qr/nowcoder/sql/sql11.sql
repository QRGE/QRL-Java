# https://www.nowcoder.com/practice/e50d92b8673a440ebdf3a517b5b37d62?tpId=82&&tqId=29763&rp=1&ru=/activity/oj&qru=/ta/sql/question-ranking
SELECT de.emp_no, dm.emp_no AS manager
FROM dept_emp de
INNER JOIN  dept_manager dm
ON (de.dept_no = dm.dept_no) AND (de.emp_no != dm.emp_no)
WHERE de.to_date = dm.to_date;