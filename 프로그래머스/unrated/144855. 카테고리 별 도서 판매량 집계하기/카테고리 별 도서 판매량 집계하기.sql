select b.category, sum(bs.sales) as TOTAL_SALES
from book_sales bs inner join book b on bs.book_id = b.book_id
where bs.sales_date like '2022-01%'
group by b.category
order by b.category