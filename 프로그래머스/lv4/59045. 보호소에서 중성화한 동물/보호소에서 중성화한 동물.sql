select ao.animal_id, ao.animal_type, ao.name
from animal_outs ao inner join animal_ins ai on ao.animal_id = ai.animal_id
where ai.sex_upon_intake != ao.sex_upon_outcome
order by ao.animal_id;