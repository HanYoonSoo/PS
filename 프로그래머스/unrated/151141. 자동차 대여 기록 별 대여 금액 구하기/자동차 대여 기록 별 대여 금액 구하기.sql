with value as (
    select car.daily_fee, car.car_type, his.history_id, DATEDIFF(end_date, start_date) + 1 AS period,
    case
        when datediff(end_date, start_date) + 1 >= 90 then '90일 이상'
        when datediff(end_date, start_date) + 1 >= 30 then '30일 이상'
        when datediff(end_date, start_date) + 1 >= 7 then '7일 이상'
        else 'NONE' end as duration_type
    from car_rental_company_rental_history his inner join car_rental_company_car car
    on his.car_id = car.car_id
    where car_type = '트럭'
)

SELECT value.history_id, 
    ROUND(value.daily_fee * value.period * 
          (100 - IFNULL(plan.discount_rate,0)) / 100) AS FEE
FROM value
LEFT JOIN car_rental_company_discount_plan AS plan 
    ON plan.duration_type = value.duration_type 
    AND plan.car_type = value.car_type
ORDER BY 2 DESC, 1 DESC;

