-- 코드를 입력하세요
-- 20240727
SELECT MEMBER_ID,MEMBER_NAME,GENDER,DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d')
from MEMBER_PROFILE
where TLNO is not Null 
           and MONTH(DATE_OF_BIRTH)=3
           and GENDER = 'W'
order by MEMBER_ID;