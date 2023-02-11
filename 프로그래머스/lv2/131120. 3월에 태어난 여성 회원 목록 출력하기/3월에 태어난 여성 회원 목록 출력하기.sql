-- 코드를 입력하세요
SELECT MEMBER_ID, member_name, gender, date_format(date_of_birth, '%Y-%m-%d') date_of_birth
from member_profile
where tlno is not null and date_of_birth like '%-03-%' and gender = 'W'
order by MEMBER_ID;