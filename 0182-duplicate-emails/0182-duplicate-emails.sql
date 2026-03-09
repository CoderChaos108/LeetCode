# Write your MySQL query statement below
select distinct id1.email as Email
from Person id1,Person id2
where id1.email=id2.email and id1.id!=id2.id;