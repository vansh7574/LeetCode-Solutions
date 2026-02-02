/* Write your T-SQL query statement below */
with min_login_dates as (
Select user_id, min(activity_date) as min_login from Traffic where activity = 'login' group by user_id
)

Select  min_login as login_date, Count(user_id) as user_count from min_login_dates where min_login >= '2019-04-01' and min_login <= '2019-06-30' group by min_login 
