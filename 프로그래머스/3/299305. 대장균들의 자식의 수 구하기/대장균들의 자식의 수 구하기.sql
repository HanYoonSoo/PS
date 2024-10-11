# -- 코드를 작성해주세요
# select id, count(parent_id)
# from ecoli_data
# group by parent_id
# having parent_id is not null
# order by id;

select A.id, coalesce(B.count, 0) as CHILD_COUNT
from ecoli_data A left join (SELECT
	PARENT_ID, COUNT(*) AS COUNT
FROM
	ECOLI_DATA
GROUP BY
	PARENT_ID
HAVING
	PARENT_ID IS NOT NULL) B
    on A.id = B.parent_id
order by A.id;