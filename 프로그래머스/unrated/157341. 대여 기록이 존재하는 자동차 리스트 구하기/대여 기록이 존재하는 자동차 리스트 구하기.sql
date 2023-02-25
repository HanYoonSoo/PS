select distinct(crcrh.car_id)
from car_rental_company_rental_history crcrh inner join car_rental_company_car crcc
on crcrh.car_id = crcc.car_id
where crcc.car_type = '세단' and crcrh.start_date like '2022-10-%'
order by crcrh.car_id desc;