# Write your MySQL query statement below
select distinct id1.email as Email
from Person id1
inner join Person id2 on id1.email=id2.email and id2.id!=id1.id