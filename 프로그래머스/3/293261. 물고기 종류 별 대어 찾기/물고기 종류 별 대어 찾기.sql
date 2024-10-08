-- 2024 08 11

SELECT I.ID AS ID, N.FISH_NAME AS FISH_NAME, I.LENGTH AS LENGTH
FROM FISH_INFO I
INNER JOIN FISH_NAME_INFO N ON I.FISH_TYPE = N.FISH_TYPE
WHERE I.FISH_TYPE IN (
    SELECT FISH_TYPE
    FROM FISH_INFO
    GROUP BY FISH_TYPE
    HAVING LENGTH = MAX(LENGTH)
)
ORDER BY I.ID ASC;