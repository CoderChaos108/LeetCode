# Write your MySQL query statement below
select dep.name as Department,emp.name as Employee,emp.salary as Salary
from Employee emp
left join Department dep on emp.departmentId=dep.id
where emp.salary=(
    select max(salary)
    from Employee
    where departmentId=emp.departmentId
);