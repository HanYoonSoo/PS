-- 코드를 입력하세요
SELECT ugb.title, ugb.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, date_format(ugr.created_date, '%Y-%m-%d') as created_date
FROM used_goods_board ugb inner join used_goods_reply ugr on ugb.board_id = ugr.board_id
where ugb.created_date like '2022-10%'
order by ugr.created_date, ugb.title;