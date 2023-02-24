-- 코드를 입력하세요
SELECT rr.rest_id, ri.rest_name, ri.food_type, ri.favorites, ri.address, round(avg(rr.review_score),2) as SCORE
from rest_review rr inner join rest_info ri on rr.rest_id = ri.rest_id
group by rr.rest_id
having ri.address like '서울%'
order by SCORE desc, ri.favorites desc;