/* Write your T-SQL query statement below */
WITH all_ids AS (
   SELECT requester_id AS id 
   FROM RequestAccepted
   UNION ALL
   SELECT accepter_id AS id
   FROM RequestAccepted)
SELECT top(1) id, 
   COUNT(id) AS num
FROM all_ids
GROUP BY id
ORDER BY COUNT(id) DESC