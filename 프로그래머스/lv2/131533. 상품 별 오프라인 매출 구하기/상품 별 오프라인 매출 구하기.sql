select product_code, sum(os.sales_amount * p.price) as sales
from offline_sale os inner join product p on os.product_id = p.product_id
group by p.product_code
order by sales desc, product_code;