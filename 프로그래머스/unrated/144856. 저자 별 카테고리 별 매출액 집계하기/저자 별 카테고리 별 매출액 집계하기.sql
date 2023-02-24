-- 코드를 입력하세요
SELECT b.author_id, a.author_name, b.category, sum(b.price * bs.sales) as total_sales
from book_sales bs inner join book b on bs.book_id = b.book_id
                   inner join author a on b.author_id = a.author_id
where bs.sales_date like '2022-01%'
group by a.author_id, b.category
order by a.author_id, b.category desc;
