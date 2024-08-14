-- 2024 08 14

SELECT I.ITEM_ID AS ITEM_ID , I.ITEM_NAME AS ITEM_NAME
FROM ITEM_INFO I
INNER JOIN ITEM_TREE T ON I.ITEM_ID = T.ITEM_ID
WHERE PARENT_ITEM_ID IS NULL;