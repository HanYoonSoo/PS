-- 코드를 입력하세요
SELECT fo.product_id, fp.product_name, sum(fp.price * fo.amount) as total_sales
from food_order fo inner join food_product fp on fo.product_id = fp.product_id
where fo.produce_date like '2022-05%'
group by fo.product_id
order by total_sales desc, fo.product_id;
