select substring(product_code, 1, 2) as category, count(*) products
from product
group by category
order by category;