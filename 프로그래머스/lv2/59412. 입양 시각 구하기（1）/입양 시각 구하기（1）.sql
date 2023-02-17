select hour(datetime) as hour, count(*)
from animal_outs
where hour(datetime) between 9 and 20
group by hour
order by hour;