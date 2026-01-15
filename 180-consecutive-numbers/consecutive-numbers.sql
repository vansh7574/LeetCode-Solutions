/* Write your T-SQL query statement below */
with lag_and_lead as(
    SELECT id, num,LEAD(num) OVER(ORDER BY id) AS lead, LAG(num) OVER (ORDER BY id) AS lag
FROM Logs
)

Select distinct num as ConsecutiveNums from lag_and_lead where num = lead and num = lag