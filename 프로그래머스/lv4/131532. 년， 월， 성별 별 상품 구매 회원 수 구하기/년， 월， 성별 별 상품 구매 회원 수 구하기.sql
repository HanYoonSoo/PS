-- 코드를 입력하세요
SELECT year(os.sales_date) as year, month(os.sales_date) as month, ui.gender, count(distinct os.user_id) as users
from online_sale os inner join user_info ui on os.user_id = ui.user_id
where ui.gender is not null
group by year, month, ui.gender
order by year, month, ui.gender;