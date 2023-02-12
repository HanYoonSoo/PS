-- 코드를 입력하세요
SELECT distinct(crcr.car_id)
from car_rental_company_car crcc inner join car_rental_company_rental_history crcr
on crcc.car_id = crcr.car_id
where crcc.car_type = '세단' and crcr.start_date like '%-10-%'
order by crcc.car_id desc;