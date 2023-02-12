-- 코드를 입력하세요
SELECT A.name, A.datetime
from ANIMAL_INS A left join ANIMAL_OUTS B on A.animal_id = B.animal_id
where B.animal_id is null
order by A.datetime
limit 3;

# SELECT A.NAME, A.DATETIME
# FROM ANIMAL_INS A LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
# WHERE B.ANIMAL_ID IS NULL
# ORDER BY A.DATETIME
# LIMIT 3