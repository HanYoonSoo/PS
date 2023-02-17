select p.product_code, sum(p.price * os.sales_amount) as sales
from offline_sale os inner join product p on os.product_id = p.product_id
group by p.product_code
order by sales desc, p.product_code;