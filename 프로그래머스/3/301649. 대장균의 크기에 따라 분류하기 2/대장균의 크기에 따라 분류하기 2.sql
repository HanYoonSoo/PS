-- 코드를 작성해주세요
select A.id, case
    when A.PER <= 0.25 then 'CRITICAL'
    when A.PER <= 0.5 then 'HIGH'
    when A.PER <= 0.75 then 'MEDIUM'
    ELSE 'LOW'
    END AS COLONY_NAME
from (select id, PERCENT_RANK() OVER (order by size_of_colony desc) as PER from ecoli_data) A
order by A.id;
