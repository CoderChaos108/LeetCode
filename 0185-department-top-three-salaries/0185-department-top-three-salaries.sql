select Department,Employee,Salary
    from (
    select dep.name as Department,emp.name as Employee,emp.salary as Salary,
    dense_rank() over (partition by emp.departmentId order by emp.salary desc) 
    as rnk
    from Employee emp
    left join Department dep
    on emp.departmentId=dep.id
) as t
 where rnk<=3