-- 코드를 작성해주세요
SELECT ii.item_id, ii.item_name, ii.rarity
FROM ITEM_INFO ii left join ITEM_TREE it on ii.item_id = it.parent_item_id
WHERE it.parent_item_id is null
ORDER BY ii.item_id desc;