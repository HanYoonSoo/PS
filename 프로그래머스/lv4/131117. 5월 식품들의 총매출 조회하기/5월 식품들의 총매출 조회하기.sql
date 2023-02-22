select fp.product_id, fp.product_name, sum(fo.amount * fp.price) total_sales
from food_product fp inner join food_order fo on fp.product_id = fo.product_id
where fo.produce_date like '2022-05%'
group by product_id
order by total_sales desc, fo.product_id;
