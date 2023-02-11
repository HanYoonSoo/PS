-- 코드를 입력하세요
SELECT max(product_id), product_name, product_cd, category, max(price)
from food_product
group by product_id
order by max(price) desc limit 1;