WITH new_table AS (
    select dep.name as Department,emp.name as Employee,emp.salary as Salary,
    dense_rank() over (partition by emp.departmentId order by emp.salary desc) 
    as rnk
    from Employee emp
    left join Department dep
    on emp.departmentId=dep.id
)
SELECT Department, Employee, Salary
FROM new_table
WHERE rnk <= 3;