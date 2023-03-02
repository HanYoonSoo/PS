select j.flavor
from july j inner join first_half fh on j.flavor = fh.flavor
group by j.flavor
order by (sum(j.total_order) + sum(fh.total_order)) desc limit 3;
