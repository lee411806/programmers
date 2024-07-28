-- 코드를 입력하세요
SELECT i.REST_ID,	i.REST_NAME,	i.FOOD_TYPE,	i.FAVORITES,	i.ADDRESS, round(avg(r.REVIEW_SCORE),2) as score
from REST_INFO i , REST_REVIEW r
where   i.REST_ID = r.REST_ID
group by REST_ID
having ADDRESS like '서울%'
order by  score desc  , FAVORITES desc;