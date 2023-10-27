-- 코드를 입력하세요
SELECT cart_id
FROM CART_PRODUCTS
WHERE NAME in ('Yogurt', 'Milk')
group by cart_id
having count(distinct(NAME)) = 2
order by cart_id;