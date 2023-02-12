-- 코드를 입력하세요
SELECT b.category, sum(bs.sales) as total_sales
from book_sales bs inner join book b on bs.book_id = b.book_id
where bs.sales_date like '2022-01%'
group by b.category
order by b.category;