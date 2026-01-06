/* Write your T-SQL query statement below */

with confirmed as 
(

 select s.user_id, COUNT(case when c.action = 'confirmed' THEN 1 END) over (partition by s.user_id) as confirmed_counts, COUNT(c.user_id) over (partition by c.user_id) as all_requests
 from Signups s Left Join Confirmations c on s.user_id = c.user_id

)

Select distinct user_id, COALESCE(ROUND(confirmed_counts * 1.0 / Nullif(all_requests,0), 2), 0) as confirmation_rate from confirmed

-- Select * from confirmed_result 

-- Select Distinct * from confirmed

-- select * from Signups s Left Join Confirmations c on s.user_id = c.user_id