-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME
from developers
where SKILL_CODE & (select code from SKILLCODES where name = 'Python') or SKILL_CODE & (select code from SKILLCODES where name = 'C#') 
order by ID;