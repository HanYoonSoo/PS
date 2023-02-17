select fh.flavor
from FIRST_HALF fh inner join icecream_info ii on fh.flavor = ii.flavor
where ii.ingredient_Type like 'fruit_based' and fh.total_order > 3000
order by fh.total_order desc;