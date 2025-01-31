Write a solution to report all the employees with their primary department.
Employees can belong to multiple departments. When the employee joins other departments,
they need to decide which department is their primary department.
Note that when an employee belongs to only one department, their primary column is 'N'.
Input:
Employee table:
+-------------+---------------+--------------+
| employee_id | department_id | primary_flag |
+-------------+---------------+--------------+
| 1           | 1             | N            |
| 2           | 1             | Y            |
| 2           | 2             | N            |
| 3           | 3             | N            |
| 4           | 2             | N            |
| 4           | 3             | Y            |
| 4           | 4             | N            |
+-------------+---------------+--------------+

Output:
+-------------+---------------+
| employee_id | department_id |
+-------------+---------------+
| 1           | 1             |
| 2           | 1             |
| 3           | 3             |
| 4           | 3             |
+-------------+---------------+

Explanation:
- The Primary department for employee 1 is 1.
- The Primary department for employee 2 is 1.
- The Primary department for employee 3 is 3.
- The Primary department for employee 4 is 3.

select
    employee_id, department_id
from
    Employee
where
    primary_flag = 'Y' OR
    employee_id in (
        select employee_id
        from Employee
        group by employee_id
        having count(employee_id) = 1
        );