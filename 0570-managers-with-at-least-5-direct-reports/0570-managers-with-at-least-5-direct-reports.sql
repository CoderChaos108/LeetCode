select e2.name as name
from Employee e2
join Employee e1
where e1.managerId=e2.id
group by e1.managerId
having count(*)>=5