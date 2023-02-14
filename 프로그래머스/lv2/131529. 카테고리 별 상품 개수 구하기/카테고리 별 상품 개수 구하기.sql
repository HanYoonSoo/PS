select substring(product_code, 1, 2) as category, count(*)
from product
group by category
order by category;