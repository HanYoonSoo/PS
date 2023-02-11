-- 코드를 입력하세요
SELECT p.product_code, sum(os.sales_amount) * p.price as 'SALES'
from offline_sale os inner join product p on os.product_id = p.product_id
group by os.product_id order by sum(os.sales_amount) * p.price desc, p.product_code asc;