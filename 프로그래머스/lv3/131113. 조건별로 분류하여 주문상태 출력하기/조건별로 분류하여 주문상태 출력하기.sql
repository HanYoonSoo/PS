-- 코드를 입력하세요
SELECT order_id, product_id, date_format(out_date, '%Y-%m-%d'), 
if(datediff('2022-05-01', out_date) >= 0, '출고완료', if(out_date is null, '출고미정', '출고대기')) '출고여부'
from food_order
order by order_id;