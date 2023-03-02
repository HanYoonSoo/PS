select year(os.sales_date), month(os.sales_date), ui.gender, count(distinct(ui.user_id))
from online_sale os inner join user_info ui on os.user_id = ui.user_id
where ui.gender is not null
group by year(os.sales_date), month(os.sales_date), ui.gender
order by year(os.sales_date), month(os.sales_date), ui.gender