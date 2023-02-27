-- 코드를 입력하세요
SELECT year(os.sales_date), month(os.sales_date), count(distinct(os.user_id)) as puchased_users, round(count(distinct(os.user_id))/ (select count(*) from user_info where joined like '2021%'), 1) as puchased_ratio
from online_sale os inner join user_info ui on os.user_id = ui.user_id
where os.user_id in (select user_id from user_info where joined like '2021%')
group by year(os.sales_date), month(os.sales_date)
order by year(os.sales_date), month(os.sales_date);