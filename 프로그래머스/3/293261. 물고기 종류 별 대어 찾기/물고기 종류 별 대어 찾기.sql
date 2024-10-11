-- 코드를 작성해주세요
select A.id, B.fish_name, A.length 
from fish_info A inner join fish_name_info B on A.fish_type = B.fish_type
where (A.fish_type, A.length) in (select fish_type, MAX(length) from fish_info group by fish_type)
order by A.id;