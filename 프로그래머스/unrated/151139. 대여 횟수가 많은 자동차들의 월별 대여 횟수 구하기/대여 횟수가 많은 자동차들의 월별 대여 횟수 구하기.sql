select month(start_date) as month, car_id, count(history_id) as records
from car_rental_company_rental_history
where car_id in (select car_id from car_Rental_company_rental_history
               where start_date between '2022-08-01' and '2022-10-31'
                group by car_id
               having count(*) >= 5)
      and start_date between '2022-08-01' and '2022-10-31'
group by month, car_id
having records > 0
order by month, car_id desc;

# select car_id, count(*) from car_Rental_company_rental_history
#                where start_date between '2022-08-31' and '2022-10-31'
#                 group by car_id
#                having count(*) >= 5;