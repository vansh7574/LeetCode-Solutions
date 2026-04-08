/* Write your T-SQL query statement below */

-- with CTE as (
--     Select distinct user_id, Round(Avg(case when activity_type = 'free_trial' Then activity_duration * 1.0 END) over (partition by user_id), 2)   as trial_avg_duration, Round(Avg(case when activity_type = 'paid' Then activity_duration * 1.0 END) over (partition by user_id ), 2)  as paid_avg_duration from UserActivity 
-- )

-- Select * from cte where paid_avg_duration is not null
with CTE as (
    Select user_id, round(avg(case when activity_type = 'free_trial' Then activity_duration * 1.0 END),2) as trial_avg_duration, round(avg(case when activity_type = 'paid' Then activity_duration * 1.0 END),2) as paid_avg_duration from UserActivity group by user_id 
)

select * from CTE where paid_avg_duration is not null
