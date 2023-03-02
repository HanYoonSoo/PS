select mp.member_name, rr.review_text, date_format(rr.review_date, '%Y-%m-%d')
from rest_review rr inner join member_profile mp on rr.member_id = mp.member_id
where rr.member_id = (select member_id from rest_review group by member_id order by count(*) desc limit 1)
order by rr.review_date, rr.review_text;