-- 코드를 입력하세요
set @HOUR = -1;

select (@HOUR := @HOUR + 1) as hour, (
    SELECT count(*)
    from animal_outs
    where hour(datetime) = @HOUR) as count
    from animal_outs
    where @HOUR < 23;


