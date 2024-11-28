-- 코드를 작성해주세요
select it.item_id, ii.item_name
from ITEM_TREE it inner join item_info ii on it.item_id = ii.item_id
where it.parent_item_id is null
order by it.item_id;