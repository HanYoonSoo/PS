select a.CAR_ID , a.CAR_TYPE ,round(DAILY_FEE * 30 * (100-DISCOUNT_RATE)/100) as 'FEE'  #, DAILY_FEE, b.DURATION_TYPE , DISCOUNT_RATE ,
from CAR_RENTAL_COMPANY_CAR a right join CAR_RENTAL_COMPANY_DISCOUNT_PLAN b
on a.CAR_TYPE = b.CAR_TYPE
where DURATION_TYPE = '30일 이상' and DAILY_FEE * 30 * (100-DISCOUNT_RATE)/100 between 500000 and 2000000
and CAR_ID in
(	
	# CAR_TYPE = 세단 or SUV
    select CAR_ID
    from CAR_RENTAL_COMPANY_CAR
    where CAR_TYPE in ('세단','SUV') and
    CAR_ID not in
    ( 
    # 11/1 - 11/30 대여 불가능 CAR_ID
    SELECT CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where DATE_FORMAT(START_DATE,'%y%m%d') between '221101' and '221130'
    or DATE_FORMAT(END_DATE,'%y%m%d') between '221101' and '221130'
    or (DATE_FORMAT(START_DATE,'%y%m%d') < '221101' and DATE_FORMAT(END_DATE,'%y%m%d') > '221130')
    )
)
order by 3 desc , 2 asc , 1 desc