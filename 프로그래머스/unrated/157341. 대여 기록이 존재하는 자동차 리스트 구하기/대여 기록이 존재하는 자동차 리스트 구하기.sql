select distinct(crcc.car_id)
from car_rental_company_rental_history crcr inner join car_rental_company_car crcc
on crcr.car_id = crcc.car_id
where crcr.start_date like '2022-10%' and crcc.car_type = '세단'
order by crcr.car_id desc;
