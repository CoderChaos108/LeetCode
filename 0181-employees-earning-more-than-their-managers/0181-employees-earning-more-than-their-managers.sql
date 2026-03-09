# Write your MySQL query statement below
select id1.name as 'Employee'
from Employee id1,Employee id2
where id1.managerId=id2.id and id1.salary>id2.salary;