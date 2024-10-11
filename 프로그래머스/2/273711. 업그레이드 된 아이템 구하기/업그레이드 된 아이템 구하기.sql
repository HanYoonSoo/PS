-- 코드를 작성해주세요
select item_id, item_name, rarity
from item_info
where item_id in (select A.item_id
                 FROM item_info I, item_tree A
                 where I.item_id = A.parent_item_id and I.RARITY = 'RARE')
order by item_id desc;