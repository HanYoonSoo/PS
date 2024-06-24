-- 코드를 작성해주세요
select year(ed1.differentiation_date) as YEAR, (ed2.SIZE - ed1.size_of_colony) as YEAR_DEV, ed1.id as ID
from ecoli_data ed1 left join 
(select year(differentiation_date) as YEAR, MAX(size_of_colony) as SIZE from ecoli_data group by year(differentiation_date)) as ed2 on year(ed1.differentiation_date) = ed2.YEAR
order by YEAR, YEAR_DEV;

